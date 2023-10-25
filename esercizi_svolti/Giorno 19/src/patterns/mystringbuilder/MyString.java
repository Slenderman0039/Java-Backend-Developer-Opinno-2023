package patterns.mystringbuilder;

public class MyString {

    private String miaStringa;

    private MyString(MyStringBuilder sb){
        this.miaStringa = sb.miaStringa;
    }
    public static class MyStringBuilder{
        private String miaStringa;
        public MyStringBuilder(){}
        public MyStringBuilder(String stringa){ this.miaStringa = stringa; }
        public MyStringBuilder append(String stringa){
            if(this.miaStringa == (null))
                this.miaStringa = stringa;
            else
                this.miaStringa = this.miaStringa + stringa;
            return this;
        }
        public MyString build(){ return new MyString(this); }
    }
    public String toString(){ return miaStringa; }
}