/**@author harry rudolph
 * Main
 */
public class Main {
    /**@ the project driver
     *
     * @param args  arguments
     */
    public static void main(String[] args) {
        FractalGenerator fg = new FractalGenerator();
        Gui gui = new Gui(fg);
        Display display = new Display(fg);

    }
}

