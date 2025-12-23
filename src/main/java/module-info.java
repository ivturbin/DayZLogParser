module dev.turbin.dayzlogparser {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.jfxtras.styles.jmetro;

    exports dev.turbin.dayzlogparser;

    opens dev.turbin.dayzlogparser to javafx.fxml;
    opens dev.turbin.dayzlogparser.model to javafx.base;
}