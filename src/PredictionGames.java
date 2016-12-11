import java.util.*;

public class PredictionGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test=0;

            test = Integer.valueOf(scanner.nextLine());

            for (int i = 0; i < test; i++) {
                Map<String, String[]> map = new HashMap<>();
                Map<String, Integer> map1 = new HashMap<>();
                int player=0;
                int competition=0;
                boolean half = false;
                player = scanner.nextInt();
                competition = scanner.nextInt();
                scanner.nextLine();
                String [] nameA = new String[player];
                for (int j = 0; j < player; j++) {
                    String name = scanner.nextLine();
                    nameA[j]=name;
                    String[] predict = new String[competition];
                    for (int k = 0; k < competition; k++) {
                        predict[k] = scanner.nextLine();
                    }
                    map.put(name, predict);
                    map1.put(name, 0);
                }

                String[] actual = new String[competition];
                for (int j = 0; j < competition; j++) {
                    actual[j] = scanner.nextLine();
                }
                for (String name : nameA) {
                    for (int j = 0; j < competition; j++) {
                        int score = 0;
                        if (!actual[j].equals("? ?")) {
                            String[] ac_res = actual[j].split(" ");
                            String[] pre_res = map.get(name)[j].split(" ");
                            if (Integer.parseInt(ac_res[0]) > Integer.parseInt(ac_res[1])) {
                                if (Integer.parseInt(pre_res[0]) > Integer.parseInt(pre_res[1])) {
                                    score += 10;
                                }

                            } else {
                                if (Integer.parseInt(pre_res[0]) < Integer.parseInt(pre_res[1])) {
                                    score += 10;
                                }
                            }
                            score += Math.max(0, 5 - Math.abs(Integer.parseInt(ac_res[0]) - Integer.parseInt(pre_res[0])));
                            score += Math.max(0, 5 - Math.abs(Integer.parseInt(ac_res[1]) - Integer.parseInt(pre_res[1])));
                            score += Math.max(0, 5 - Math.abs(Integer.parseInt(pre_res[1]) - Integer.parseInt(pre_res[0]) - Integer.parseInt(ac_res[1]) + Integer.parseInt(ac_res[0])));
                        } else {
                            half = true;
                        }
                        map1.put(name, map1.get(name) + score);
                    }
                }
                System.out.println(map1);
                int[] win = new int[player];
                if (half) {
                    int p1=0;
                    for (String name : nameA) {
                        int[] scores = new int[player];
                        for (int j = 0; j < competition; j++) {
                            if (actual[j].equals("? ?")) {
                                String[] pre_res1 = map.get(name)[j].split(" ");
                                String[] ac_res = pre_res1.clone();
                                scores[p1] = map1.get(name) + 25;
                                int p2 = 0;
                                for (String name1 :nameA) {
                                    if(!name1.equals(name)){
                                    String[] pre_res = map.get(name1)[j].split(" ");
                                    int score = map1.get(name1);
//                                        System.out.println(score);
                                    if (Integer.parseInt(ac_res[0]) > Integer.parseInt(ac_res[1])) {
                                        if (Integer.parseInt(pre_res[0]) > Integer.parseInt(pre_res[1])) {
                                            score += 10;
                                        }
                                    } else {
                                        if (Integer.parseInt(pre_res[0]) < Integer.parseInt(pre_res[1])) {
                                            score += 10;
                                        }
                                    }

                                    score += Math.max(0, 5 - Math.abs(Integer.parseInt(ac_res[0]) - Integer.parseInt(pre_res[0])));
                                    score += Math.max(0, 5 - Math.abs(Integer.parseInt(ac_res[1]) - Integer.parseInt(pre_res[1])));
                                    score += Math.max(0, 5 - Math.abs(Integer.parseInt(pre_res[0]) - Integer.parseInt(pre_res[1]) - Integer.parseInt(ac_res[0]) + Integer.parseInt(ac_res[1])));

                                    scores[p2] = score;
                                    p2++;
                                }
                                }

                            }
                        }
                        System.out.println(Arrays.toString(win));
                        p1++;
                        int max = scores[0];
                        int index = 0;
                        for (int t = 0; t < player; t++) {
                            if (max <= scores[t]) {
                                max = scores[t];
                                index = t;
                            }
                        }
                        win[index] += 1;
                    }
                    ArrayList<String> na = new ArrayList<>();
                    for (int j = 0; j < player; j++) {

                        if (win[j] > 0) {
                            na.add(nameA[j]);
                        }
                    }
                    Collections.sort(na);
                    for(String a:na){
                        System.out.print(a +" ");
                    }
                    System.out.println();

                }

                else{
                    ArrayList<Integer> j = new ArrayList<>();
                    for(String s:nameA){
                        j.add(map1.get(s));
                    }
                    int ma = Collections.max(j);
                    ArrayList<String> na = new ArrayList<>();
                    for(String s:nameA){
                        if(ma==map1.get(s)){
                            na.add(s);
                        }
                    }
                    Collections.sort(na);
                    for(String a:na){
                        System.out.print(a +" ");
                    }
                    System.out.println();
                }
            }
    }
}