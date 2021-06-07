package View;

import javax.swing.JProgressBar;

public class ProgressThreads extends Thread {

    JProgressBar progreso;

    public ProgressThreads(JProgressBar progreso1) {
        super();
        this.progreso = progreso1;
    }

    public void run() {
        int l = 0;
        for (l = 1; l <= 100; l++) {
            progreso.setValue(l);
            pausa(20);
        }

    }

    public void pausa(int mlSeg) {
        try {
            // pausa para el splash
            Thread.sleep(mlSeg);
        } catch (Exception e) {
        }
    }
}
