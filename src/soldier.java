/**
 * Created by smtt on 10/22/16.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author singam
 */
public class soldier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan= new Scanner(System.in);
        int sol=scan.nextInt();
        double[] temp=new double[2];
        scan.nextLine();
//        ArrayList<double[]> soldier=new ArrayList<>();
        double[][] soldier = new double[sol][2];
        double[][] camp = new double[sol][2];
//        ArrayList<double[]> camp=new ArrayList<>();
        for(int q=0;q<sol;q++){
            temp[0]=scan.nextDouble();
            temp[1]=scan.nextDouble();
            soldier[q]=(temp.clone());
//            System.out.println(Arrays.toString(temp));
        }

        for(int q=0;q<sol;q++){
            temp[0]=scan.nextDouble();
            temp[1]=scan.nextDouble();
            camp[q]=temp.clone();
//            System.out.println(Arrays.deepToString(camp));
//             System.out.println(Arrays.toString(temp));
        }
//        System.out.println(Arrays.deepToString(soldier));
//        System.out.println(Arrays.deepToString(camp));
        double[][] data=new double[sol][sol];
        for(int i=0; i<sol;i++){
            for(int j=0;j<sol;j++){
//                System.out.println(camp[i][0]);
                data[i][j]=dis(camp[j][0],soldier[i][0],camp[j][1],soldier[i][1]);

            }
        }
        System.out.println(Arrays.deepToString(data));
        Hungarian op = new Hungarian(data);
        int [] array = op.execute();
        System.out.println(Arrays.toString(array));

    }
    public static double dis(double x1,double y1,double x2, double y2){
        double dis=Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*y1-y2));
        return dis;
    }




}

class Hungarian {
    private final double[][] costMatrix;
    private final int rows, cols, dim;
    private final double[] labelByWorker, labelByJob;
    private final int[] minSlackWorkerByJob;
    private final double[] minSlackValueByJob;
    private final int[] matchJobByWorker, matchWorkerByJob;
    private final int[] parentWorkerByCommittedJob;
    private final boolean[] committedWorkers;

    public Hungarian(double[][] costMatrix) {
        this.dim = Math.max(costMatrix.length, costMatrix[0].length);
        this.rows = costMatrix.length;
        this.cols = costMatrix[0].length;
        this.costMatrix = new double[this.dim][this.dim];
        for (int w = 0; w < this.dim; w++) {
            if (w < costMatrix.length) {
                if (costMatrix[w].length != this.cols) {
                    throw new IllegalArgumentException("Irregular cost matrix");
                }
                this.costMatrix[w] = Arrays.copyOf(costMatrix[w], this.dim);
            } else {
                this.costMatrix[w] = new double[this.dim];
            }
        }
        labelByWorker = new double[this.dim];
        labelByJob = new double[this.dim];
        minSlackWorkerByJob = new int[this.dim];
        minSlackValueByJob = new double[this.dim];
        committedWorkers = new boolean[this.dim];
        parentWorkerByCommittedJob = new int[this.dim];
        matchJobByWorker = new int[this.dim];
        Arrays.fill(matchJobByWorker, -1);
        matchWorkerByJob = new int[this.dim];
        Arrays.fill(matchWorkerByJob, -1);
    }


    protected void computeInitialFeasibleSolution() {
        for (int j = 0; j < dim; j++) {
            labelByJob[j] = Double.POSITIVE_INFINITY;
        }
        for (int w = 0; w < dim; w++) {
            for (int j = 0; j < dim; j++) {
                if (costMatrix[w][j] < labelByJob[j]) {
                    labelByJob[j] = costMatrix[w][j];
                }
            }
        }
    }


    public int[] execute() {

        reduce();
        computeInitialFeasibleSolution();
        greedyMatch();

        int w = fetchUnmatchedWorker();
        while (w < dim) {
            initializePhase(w);
            executePhase();
            w = fetchUnmatchedWorker();
        }
        int[] result = Arrays.copyOf(matchJobByWorker, rows);
        for (w = 0; w < result.length; w++) {
            if (result[w] >= cols) {
                result[w] = -1;
            }
        }
        return result;
    }
    protected void executePhase() {
        while (true) {
            int minSlackWorker = -1, minSlackJob = -1;
            double minSlackValue = Double.POSITIVE_INFINITY;
            for (int j = 0; j < dim; j++) {
                if (parentWorkerByCommittedJob[j] == -1) {
                    if (minSlackValueByJob[j] < minSlackValue) {
                        minSlackValue = minSlackValueByJob[j];
                        minSlackWorker = minSlackWorkerByJob[j];
                        minSlackJob = j;
                    }
                }
            }
            if (minSlackValue > 0) {
                updateLabeling(minSlackValue);
            }
            parentWorkerByCommittedJob[minSlackJob] = minSlackWorker;
            if (matchWorkerByJob[minSlackJob] == -1) {

                int committedJob = minSlackJob;
                int parentWorker = parentWorkerByCommittedJob[committedJob];
                while (true) {
                    int temp = matchJobByWorker[parentWorker];
                    match(parentWorker, committedJob);
                    committedJob = temp;
                    if (committedJob == -1) {
                        break;
                    }
                    parentWorker = parentWorkerByCommittedJob[committedJob];
                }
                return;
            } else {
                int worker = matchWorkerByJob[minSlackJob];
                committedWorkers[worker] = true;
                for (int j = 0; j < dim; j++) {
                    if (parentWorkerByCommittedJob[j] == -1) {
                        double slack = costMatrix[worker][j] - labelByWorker[worker]
                                - labelByJob[j];
                        if (minSlackValueByJob[j] > slack) {
                            minSlackValueByJob[j] = slack;
                            minSlackWorkerByJob[j] = worker;
                        }
                    }
                }
            }
        }
    }

    protected int fetchUnmatchedWorker() {
        int w;
        for (w = 0; w < dim; w++) {
            if (matchJobByWorker[w] == -1) {
                break;
            }
        }
        return w;
    }

    protected void greedyMatch() {
        for (int w = 0; w < dim; w++) {
            for (int j = 0; j < dim; j++) {
                if (matchJobByWorker[w] == -1 && matchWorkerByJob[j] == -1
                        && costMatrix[w][j] - labelByWorker[w] - labelByJob[j] == 0) {
                    match(w, j);
                }
            }
        }
    }
    protected void initializePhase(int w) {
        Arrays.fill(committedWorkers, false);
        Arrays.fill(parentWorkerByCommittedJob, -1);
        committedWorkers[w] = true;
        for (int j = 0; j < dim; j++) {
            minSlackValueByJob[j] = costMatrix[w][j] - labelByWorker[w]
                    - labelByJob[j];
            minSlackWorkerByJob[j] = w;
        }
    }

    protected void match(int w, int j) {
        matchJobByWorker[w] = j;
        matchWorkerByJob[j] = w;
    }

    protected void reduce() {
        for (int w = 0; w < dim; w++) {
            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < dim; j++) {
                if (costMatrix[w][j] < min) {
                    min = costMatrix[w][j];
                }
            }
            for (int j = 0; j < dim; j++) {
                costMatrix[w][j] -= min;
            }
        }
        double[] min = new double[dim];
        for (int j = 0; j < dim; j++) {
            min[j] = Double.POSITIVE_INFINITY;
        }
        for (int w = 0; w < dim; w++) {
            for (int j = 0; j < dim; j++) {
                if (costMatrix[w][j] < min[j]) {
                    min[j] = costMatrix[w][j];
                }
            }
        }
        for (int w = 0; w < dim; w++) {
            for (int j = 0; j < dim; j++) {
                costMatrix[w][j] -= min[j];
            }
        }
    }

    protected void updateLabeling(double slack) {
        for (int w = 0; w < dim; w++) {
            if (committedWorkers[w]) {
                labelByWorker[w] += slack;
            }
        }
        for (int j = 0; j < dim; j++) {
            if (parentWorkerByCommittedJob[j] != -1) {
                labelByJob[j] -= slack;
            } else {
                minSlackValueByJob[j] -= slack;
            }
        }
    }

}