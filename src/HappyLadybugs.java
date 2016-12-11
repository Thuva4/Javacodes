import java.util.Arrays;

/**
 * Created by smtt on 10/11/16.
 */
public class HappyLadybugs {
    public static void main(String[] args) {
        String d= "X_YX";
        String[] s = d.split("");
        boolean finished = false;

        int total = 0;
        String pre = null;
        int Pindex = 0;
        String next = null;
        int Nindex = 0;
        Boolean can = true;
        while (!finished && can) {
            can=false;

            System.out.println(Arrays.toString(s));
            for (int i = 0; i < s.length; i++) {

                if (s[i].equals("_")) {
                    if (i != 0) {
                        pre = s[i - 1];
                        Pindex = i - 1;
                    }
                    if (i != s.length - 1) {
                        next = s[i + 1];
                        Nindex = i + 1;
                    }
//                    break;

                }

                if (s[i].equals(pre) && !s[i].equals("_") && i != Pindex) {
                    if (i <s.length-1) {
                        if (!s[i].equals(s[i+ 1])) {
                            String temp = s[i];
                            s[i] = "_";
                            s[Pindex + 1] = temp;
                            if (i != 0) {
                                pre = s[i - 1];
                                Pindex = i - 1;
                            }
                            if (i != s.length - 1) {
                                next = s[i + 1];
                                Nindex = i + 1;

                            }

                            total = total + 2;
                            can=true;
                            break;
                        }
                    }
                    else {
                        String temp = s[i];
                        s[i] = "_";
                        s[Pindex + 1] = temp;
                        if (i != 0) {
                            pre = s[i - 1];
                            Pindex = i - 1;
                        }
                        if (i != s.length - 1) {
                            next = s[i + 1];
                            Nindex = i + 1;

                        }

                        total = total + 2;
                        can=true;
                        break;

                    }
                }
                else if (s[i].equals(next) && !s[i].equals("_") && i != Nindex) {
                    if (i >0) {
                        if (!s[i].equals(s[i - 1])) {
                            String temp = s[i];
                            s[i] = "_";
                            s[Nindex - 1] = temp;

                            if (i != 0) {
                                pre = s[i - 1];
                                Pindex = i - 1;
                            }
                            if (i != s.length - 1) {
                                next = s[i + 1];
                                Nindex = i + 1;
                            }
                            total = total + 2;
                            can=true;
                            break;
                        }
                    }
                    else {
                        String temp = s[i];
                        s[i] = "_";
                        s[Nindex - 1] = temp;

                        if (i != 0) {
                            pre = s[i - 1];
                            Pindex = i - 1;
                        }
                        if (i != s.length - 1) {
                            next = s[i + 1];
                            Nindex = i + 1;
                        }
                        total = total + 2;
                        can=true;
                        break;
                    }
                }

                System.out.println(total);
                if (total >= d.replaceAll("_","").length()) {
                    finished = true;
                }


            }
//            System.out.println(Arrays.toString(s));
        }
    }
}

