package main;

public class Lion {
    public String name;
    String specialty;
    private int horseman;

    public Lion(String name, String specialty, int horseman) {
        this.name = name;
        this.specialty = specialty;
        this.horseman = horseman;
    }

    public int getHorsman(){
        return horseman;
    }

    int e = 0;
    public boolean verification1 (String a) {
        if (a.equals("") || a.equals(" ")) {
            return true;
        }
        return false;
    }

    public boolean verification2 (String b) {
        if (b.equals("") || b.equals(" ")) {
            return true;
        }
        return false;
    }

    public boolean verification3 (int c){
        if (c < 1) {
            return true;
        }
        return false;
    }


    public String verification (boolean a, boolean b, boolean c, Lion l){
        if (a||b||c){
            return "잘못된 아기사자 정보입니다.";
        } else {
            return "아기사자 객체가 자신의 상태를 정상으로 판단했습니다.\n아기사자 정보를 출력합니다." +
                    "\n"+"이름: "+l.name+" | 전공: "+l.specialty+" | 기수: "+l.horseman;
        }
    }
}

