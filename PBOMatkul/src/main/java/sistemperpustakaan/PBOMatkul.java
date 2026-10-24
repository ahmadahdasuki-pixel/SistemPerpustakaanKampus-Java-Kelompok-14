
package sistemperpustakaan;


import sistemperpustakaan.view.PerpustakaanView;
import sistemperpustakaan.controller.PerpustakaanController;

public class PBOMatkul {
    public static void main(String[] args) {
        PerpustakaanView view = new PerpustakaanView();

        PerpustakaanController controller =
                new PerpustakaanController(view);

        controller.jalankan();
    }
}