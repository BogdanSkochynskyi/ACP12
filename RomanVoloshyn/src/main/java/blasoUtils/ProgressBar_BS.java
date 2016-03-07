package blasoUtils;

public class ProgressBar_BS {

    private final int width = 50; // progress bar width in chars
    private String pattern = "";

    private final int step = 2;
    private int prevStep = -1;

    public ProgressBar_BS(){
    }

    public void updateProgress(double progressPercentage) {

        double percent = Math_BS.roundTo(progressPercentage, 2);
        int currentSteps = (int) percent/step;

        System.out.print("\r");
        System.out.print(String.format("%3.2f", percent));
        System.out.print(" %");

        if (currentSteps > prevStep){

            prevStep = currentSteps;
            updateProgressPattern();

        }

        System.out.print(pattern);
    }

    private void updateProgressPattern(){

        StringBuilder sb = new StringBuilder(52);

        sb.append("[");
        int i = 0;
        for (; i <= prevStep; i++) {
            sb.append("#");
        }
        for (; i < width; i++) {
            sb.append(" ");
        }
        sb.append("]");

        pattern = sb.toString();
    }
}