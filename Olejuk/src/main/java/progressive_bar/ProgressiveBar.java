package progressive_bar;

/**
 * Created by dexter on 07.03.16.
 */
public class ProgressiveBar {

    static void updateProgress(double progressPercentage) {

        final int step = 2;
        final int width = 50; // progress bar width in chars

        double percent = Double.parseDouble(String.format("%.2f", progressPercentage));
        int currentSteps = (int) percent/step;

        System.out.append("\r " + percent + " %: [");
        int i = 0;
        for (; i <= currentSteps; i++) {
            System.out.append(".");
        }
        for (; i < width; i++) {
            System.out.append(" ");
        }
        System.out.append("]");
    }

}
