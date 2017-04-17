/*
 * @class   frontend.AboutWindowController
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Controller des About Fensters.
 *
 */

package frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AboutWindowController {
    private Stage aboutWindowStage;

    @FXML
    private TextArea aboutTextArea;

    @FXML
    private Label versionLabel;

    public void setStage(Stage aboutWindowStage) {
            this.aboutWindowStage = aboutWindowStage;
            this.aboutTextArea.setText(
                    "\u00A9" + "2017 by Tamino Dörr, Salvatore Marino, Andreas Boesen\n\n" +
                    "\u00A9" + "2017 Akademie für Datenverarbeitung Böblingen\n" +
                    "\tAußenstelle der Gottlieb-Daimler-Schule 2 Sindelfingen \n\tURL ADV Böblingen: <https://www.adv-boeblingen.de/adv/>" +
                    "\n\n\n\n" +
                    "ISC License (ISC)" +
                    "\n\n" +
                    "Permission to use, copy, modify, and/or distribute this software for any " +
                    "purpose with or without fee is hereby granted, provided that the above " +
                    "copyright notice and this permission notice appear in all copies. " +
                    "\n\n" +
                    "THE SOFTWARE IS PROVIDED \"AS IS\" AND THE AUTHOR DISCLAIMS ALL WARRANTIES " +
                    "WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF " +
                    "MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR " +
                    "ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES " +
                    "WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN " +
                    "ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF " +
                    "OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE." +
                    "\n\n\n" +
                    "====================\n" +
                    "License addendum regarding SAP\n" +
                    "====================\n\n" +
                    "All trademarks, copyrights, ... regarding the SAP brand/products/APIs/... " +
                    "that may have been used or mentioned in this project remain unaffected by " +
                    "the LICENSE chosen for this project and are therefore copyright by the " +
                    "SAP SE <https://en.wikipedia.org/wiki/SAP_SE> and licensed under their " +
                    "respective (probably) proprietary licenses. "
                    );

            versionLabel.setText("Version: 0.0.1");
    }

    @FXML
    private ScrollPane AboutScrollPane;
    @FXML
    public void AboutWindow_CloseButton() {
        this.aboutWindowStage.close();
    }
}
