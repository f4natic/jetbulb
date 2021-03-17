package test_task;

public class Run {
    public static void main(String[] args) {
        System.out.println("XXX = " + new NotationConverter().toArabic("XXX"));
        System.out.println("XIX = " + new NotationConverter().toArabic("XIX"));
        System.out.println("MMMMMMM = " + new NotationConverter().toArabic("MMMMMMM"));
// --wrong       System.out.println("XIXXX = " + new NotationConverter().toArabic("XIXXX")); <- need help
        System.out.println("dcx = " + new NotationConverter().toArabic("dcx"));
        System.out.println("dcx = " + new NotationConverter().toArabic("dcx"));
//        System.out.println("null = " + new NotationConverter().toArabic(""));
//        System.out.println("null = " + new NotationConverter().toArabic(null));
        System.out.println("IMM = " + new NotationConverter().toArabic("IMM"));
        System.out.println("A = " + new NotationConverter().toArabic("A"));
    }
}
