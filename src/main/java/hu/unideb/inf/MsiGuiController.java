package hu.unideb.inf;

import hu.unideb.inf.DAO.JPAPatientDAO;
import hu.unideb.inf.Modell.Model;
import hu.unideb.inf.Modell.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MsiGuiController implements Initializable {

    private Model model;

    @FXML
    private TableView<Patient> patientsTable;

    @FXML
    private TableColumn<Patient, Integer> cardNumberCol;

    @FXML
    private TableColumn<Patient, String> nameCol;

    @FXML
    private TableColumn<Patient, String> mothersNameCol;

    @FXML
    private TableColumn<Patient, String> genderCol;

    @FXML
    private TableColumn<Patient, String> birthDateCol;

    @FXML
    private TableColumn<Patient, String> insuranceIDCol;

    @FXML
    private TableColumn<Patient, Integer> zipcodeCol;

    @FXML
    private TableColumn<Patient, String> cityCol;

    @FXML
    private TableColumn<Patient, String> streetCol;

    @FXML
    private TableColumn<Patient, String> streetNumberCol;

    @FXML
    private TextField cardnumToRemove;

    @FXML
    private TextField nameInputField;

    @FXML
    private TextField cardnumInputField;

    @FXML
    private TextField motherNameInputField;

    @FXML
    private TextField insuranceIdInputField;

    @FXML
    private TextField birthdateInputField;

    @FXML
    private TextArea diagnoseInputField;

    @FXML
    private TextField cityInputField;

    @FXML
    private TextField streetInputField;

    @FXML
    private TextField streetNumberInputField;

    @FXML
    private TextField zipcodeInputField;

    @FXML
    private TextField modiyfNameInputField;

    @FXML
    private TextField modifyCardnumInputField;

    @FXML
    private TextField modifyMotherNameInputField;

    @FXML
    private TextField modifyInsuranceIdInputField;

    @FXML
    private TextField modifyBirthDateInputField;

    @FXML
    private TextArea modifyDiagnoseInputField;

    @FXML
    private TextField modifyZipcodeInputField;

    @FXML
    private TextField modifyCityInputField;

    @FXML
    private TextField modifyStreetInputField;

    @FXML
    private TextField modifyStreetNumberInputField;

    @FXML
    private TextField searchElementInput;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private Label foundElementsNumber;

    @FXML Pane exitOverlay;

    @FXML Button ExitOverlayButtonShow,ExitOverlayButtonHide;

    @FXML private Pane topPane;

    @FXML private AnchorPane parent;

    @FXML private Pane overlay;

    @FXML private Button overlayButton, overlayHideButton;

    @FXML private Pane themeOverlay;

    @FXML private Button themeOverlayButton, themeOverlayButtonHide;

    @FXML private Pane overlay_help;

    @FXML private Button helpButton,helpButtonHide;

    @FXML private ChoiceBox<String> myChoiceBox;

    @FXML Button RandomNumberButton;

    @FXML private Pane foundElementsNumberID;

    @FXML private Label SelectPatientLabel,DiagnoseLabel,Diagnoses;

    @FXML private Button ConfirmButton_SelectPatientLabel;

    private final String[] searchElements ={"Név","Város","Kartonszám","TAJ/Azonosító"};

    private double x,y;

    public void setModel(Model model) {
        this.model = model;
    }

    public void init(Stage stage){

        topPane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        topPane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);

        });

    }

    @FXML
    void themeWithRadius(ActionEvent event) {
        parent.getStylesheets().remove("/fxml/withoutradius.css");
        parent.getStylesheets().add("/fxml/withradius.css");
    }

    @FXML
    void themeWithoutRadius(ActionEvent event){
        parent.getStylesheets().remove("/fxml/withradius.css");
        parent.getStylesheets().add("/fxml/withoutradius.css");
    }

    public void WinterButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/style.css").toExternalForm());
    }

    public void AutumnButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/autumn.css").toExternalForm());
    }

    public void LightButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/light.css").toExternalForm());
    }

    public void DarkButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/dark.css").toExternalForm());
    }

    public void RazerButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/razer.css").toExternalForm());
    }

    public void GreenButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/pink.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/green.css").toExternalForm());
    }

    public void PinkButton(ActionEvent event){
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/autumn.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/light.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/dark.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/razer.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/green.css").toExternalForm());
        parent.getScene().getStylesheets().remove(getClass().getResource("/fxml/style.css").toExternalForm());
        parent.getScene().getStylesheets().add(getClass().getResource("/fxml/pink.css").toExternalForm());
    }

    @FXML
    void overlayAction(ActionEvent event) {
        if (event.getSource() == overlayButton)
        {
            overlay.toFront();
        }
    }

    @FXML
    void overlayActionHide(ActionEvent event) {
        if (event.getSource() == overlayHideButton)
        {
            overlay.toBack();
        }
    }

    @FXML
    void ExitOverlayButtonAction(ActionEvent event) {
        if (event.getSource() == ExitOverlayButtonShow)
        {
            exitOverlay.toFront();
        }
    }

    @FXML
    void ExitOverlayButtonActionHide2(ActionEvent event) {
        if (event.getSource() == ExitOverlayButtonHide)
        {
            exitOverlay.toBack();
        }
    }

    //THEME

    @FXML
    void themeOverlayAction(ActionEvent event) {

        if (event.getSource() == themeOverlayButton)
        {
            themeOverlay.toFront();
        }

    }

    @FXML
    void themeOverlayActionHide(ActionEvent event) {
        if (event.getSource() == themeOverlayButtonHide)
        {
            themeOverlay.toBack();
        }
    }

    @FXML
    private void Close(ActionEvent event) {
        Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
        s.close();
    }

    @FXML
    private void Tray(ActionEvent event) {
        Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
        s.setIconified(true);
    }

    @FXML
    public void LogoutButton(ActionEvent event) throws IOException {
        backToLoginInterfaceEvent(event);
    }

    private void backToLoginInterfaceEvent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loginpage.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(new Image("/img/windowsicon.png"));
        ((MsiGuiController)fxmlLoader.getController()).init(stage);
        Close(event);
        stage.show();
    }

    @FXML
    void HelpAction(ActionEvent event) {
        if (event.getSource() == helpButton)
        {
            overlay_help.toFront();
        }
    }

    @FXML
    void helpOverlayActionHide(ActionEvent event) {
        if (event.getSource() == helpButtonHide)
        {
            overlay_help.toBack();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(searchElements);

        cardNumberCol.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mothersNameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfMother"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        insuranceIDCol.setCellValueFactory(new PropertyValueFactory<>("socialInsuranceId"));
        zipcodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
        streetNumberCol.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        patientsTable.setItems(listPatientsToUI());
    }

    @FXML
    void RandomNumberAction(ActionEvent event) {
        try (JPAPatientDAO patientDAO = new JPAPatientDAO()) {
            Random rand = new Random();
            int n = rand.nextInt(10000);
            n += 1;

            if (patientDAO.cardnumberAlreadyExists(n)){
                RandomNumberAction(event);
            }
            else if (event.getSource() == RandomNumberButton)
            {
                cardnumInputField.setText(Integer.toString(n));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML void DisableMouse2(MouseEvent event) {
        cardnumInputField.setEditable(false);
    }

    @FXML private Label SuccesPatient,RemoveSuccesPatient,ModifyMessage;

    ObservableList<Patient> listPatientsForSearching(String elementToSearch, String searchBarText){
        ObservableList<Patient> patients = FXCollections.observableArrayList();

        try(JPAPatientDAO aDAO = new JPAPatientDAO()){
            List<Patient> listOfPatients = aDAO.getPatients();

            for (Patient p : listOfPatients){
                if (elementToSearch.contains("Név")){
                    if (p.getName().contains(searchBarText)){
                        patients.add(p);
                    }
                }
                else if(elementToSearch.matches("Kartonszám")){
                    if (Integer.parseInt(searchBarText) == p.getCardNumber()){
                        patients.add(p);
                    }
                }
                else if(elementToSearch.contains("Város")){
                    if (p.getCity().matches(searchBarText)){
                        patients.add(p);
                    }
                }
                else if(elementToSearch.matches("TAJ/Azonosító")){
                    if (Integer.parseInt(searchBarText) == p.getSocialInsuranceId()){
                        patients.add(p);
                    }
                }
            }

        }catch (Exception e){

        }
        return patients;
    }

    ObservableList<Patient> listPatientsToUI(){
        ObservableList<Patient> patients = FXCollections.observableArrayList();

        try(JPAPatientDAO aDAO = new JPAPatientDAO()){
            List<Patient> listOfPatients = aDAO.getPatients();

            for (Patient p : listOfPatients){
                patients.add(p);
            }

        }catch (Exception e){

        }

        return patients;
    }

    @FXML
    public void PatientRemoveButtonPushed(ActionEvent event){

        if(cardnumToRemove.getText().isEmpty()){
            SearchPatientFailed("A törléshez ki kell tölteni a kartonszám mezőt!");
            return;
        }

        if (!cardnumToRemove.getText().matches("[0-9]+")){
            SearchPatientFailed("A kartonszám csak számot tartalmaz!");
            return;
        }

        try(JPAPatientDAO aDAO = new JPAPatientDAO()){

            if (!aDAO.cardnumberAlreadyExists(Integer.parseInt(cardnumToRemove.getText()))){
                SearchPatientFailed("A kartonszám nem létezik!");
                return;
            }

            List<Patient> patients = aDAO.getPatients();

            for (Patient p : patients){
                if (p.getCardNumber() == Integer.parseInt(cardnumToRemove.getText())){
                    aDAO.deletePatient(p);
                }
            }

            cardnumToRemove.setText("");

            patientsTable.setItems(listPatientsToUI());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML public void PatientRegisterButtonPushed(ActionEvent event) {

        if (!isAllFilled()){
            MessageFailed("Minden mezőt kötelező kitölteni!");
            return;
        }
        if (!zipcodeInputField.getText().matches("[0-9]+") || !insuranceIdInputField.getText().matches("[0-9]+") || !streetNumberInputField.getText().matches("[0-9]+")){
            MessageFailed("Az irányítószám, házszám és tajszám mezők\n csak számokat tartalmazhatnak!");
            return;
        }
        if(insuranceIdInputField.getText().length() != 9){
            MessageFailed("A tajszám 9 számot tartalmaz!");
            return;
        }
        if(!isValidBirthDate(birthdateInputField.getText())){
            MessageFailed("Helytelen születési dátum!\nHelyes formátum: ÉÉÉÉ-HH-NN");
            return;
        }
        if (!nameInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+") || !motherNameInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+") || !cityInputField.getText().matches("[[a-zA-Z]+ÉÁÖÜÓŐÚŰÍéáöüóőúűí]+") || !streetInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+"))
        {
            MessageFailed("A Név, Anyja neve, Város és Utca mezők\n csak betűket tartalmazhatnak!");
            return;
        }

        try(JPAPatientDAO aDAO = new JPAPatientDAO()){

            Patient patient = new Patient();
            patient.setName(nameInputField.getText());
            patient.setCity(cityInputField.getText());
            patient.setBirthDate(birthdateInputField.getText());
            patient.setCardNumber(Integer.parseInt(cardnumInputField.getText()));
            patient.setDiagnose(diagnoseInputField.getText());
            patient.setNameOfMother(motherNameInputField.getText());
            patient.setStreetNumber(streetNumberInputField.getText());
            patient.setZipCode(Integer.parseInt(zipcodeInputField.getText()));
            patient.setStreet(streetInputField.getText());
            patient.setSocialInsuranceId(Integer.parseInt(insuranceIdInputField.getText()));

            if (radioMale.isSelected()){
                patient.setGender("MALE");
            }else {
                patient.setGender("FEMALE");
            }

            aDAO.savePatient(patient);

            clearTexts();

            MessageSuccess("A beteg sikeresen felvételre került!");
            patientsTable.setItems(listPatientsToUI());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void SearchButtonPushed(ActionEvent event){

        String elementToSearch = searchElementInput.getText();
        String choiceBoxValue = myChoiceBox.getValue();

        if (elementToSearch.isEmpty()){
            SearchPatientFailed("Írjon be keresendő szöveget!");
            foundElementsNumberID.setOpacity(0);
            return;
        }
        if (choiceBoxValue == null){
            SearchPatientFailed("Válassza ki mi alapján szeretne keresni!");
            foundElementsNumberID.setOpacity(0);
            return;
        }

        int foundPatientsLength = 0;

        if (choiceBoxValue.matches("Név")){
            if (!elementToSearch.matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+")){
                SearchPatientFailed("A név csak betűt tartalmazhat!");
                foundElementsNumberID.setOpacity(0);
                return;
            }
            patientsTable.setItems(listPatientsForSearching("Név",elementToSearch));
            foundPatientsLength = listPatientsForSearching("Név",elementToSearch).size();
        }else if(choiceBoxValue.matches("Kartonszám")){
            if (!elementToSearch.matches("[0-9]+")){
                SearchPatientFailed("A kartonszám csak számot tartalmazhat!");
                foundElementsNumberID.setOpacity(0);
                return;
            }
            patientsTable.setItems(listPatientsForSearching("Kartonszám",elementToSearch));
            foundPatientsLength = listPatientsForSearching("Kartonszám",elementToSearch).size();
        }else if(choiceBoxValue.matches("Város")){
            if (!elementToSearch.matches("[[a-zA-Z]+ÉÁÖÜÓŐÚŰÍéáöüóőúűí]+")){
                SearchPatientFailed("A város csak betűt tartalmazhat!");
                foundElementsNumberID.setOpacity(0);
                return;
            }
            patientsTable.setItems(listPatientsForSearching("Város",elementToSearch));
            foundPatientsLength = listPatientsForSearching("Város",elementToSearch).size();
        }else if(choiceBoxValue.matches("TAJ/Azonosító")){
            if (!elementToSearch.matches("[0-9]+") || elementToSearch.length() !=9){
                SearchPatientFailed("A tajszám csak számot tartalmazhat,\n és 9 szám lehet!");
                foundElementsNumberID.setOpacity(0);
                return;
            }
            patientsTable.setItems(listPatientsForSearching("TAJ/Azonosító",elementToSearch));
            foundPatientsLength = listPatientsForSearching("TAJ/Azonosító",elementToSearch).size();
        }
        foundElementsNumberID.setOpacity(1);
        foundElementsNumber.setText("" + foundPatientsLength);
        SearchPatientSuccess("Sikeres Keresés");
        searchElementInput.setText("");
    }

    @FXML
    public void ListAllPatientButtonPushed(ActionEvent event){
        patientsTable.setItems(listPatientsToUI());
        foundElementsNumberID.setOpacity(0);
        SearchPatientSuccess("Betegek listázva.");
    }

    @FXML
    public void clickTable(MouseEvent event){
        if (event.getClickCount() == 1){
            SelectPatientLabel.setText("");
            DiagnoseLabel.setText("Diagnózis:");
            Diagnoses.setText(patientsTable.getSelectionModel().getSelectedItem().getDiagnose());
            ConfirmButton_SelectPatientLabel.setOpacity(1);
            modifyCardnumInputField.setText(String.valueOf(patientsTable.getSelectionModel().getSelectedItem().getCardNumber()));
            modiyfNameInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getName());
            modifyMotherNameInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getNameOfMother());
            modifyInsuranceIdInputField.setText(String.valueOf(patientsTable.getSelectionModel().getSelectedItem().getSocialInsuranceId()));
            modifyBirthDateInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getBirthDate());
            modifyZipcodeInputField.setText(String.valueOf(patientsTable.getSelectionModel().getSelectedItem().getZipCode()));
            modifyCityInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getCity());
            modifyStreetInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getStreet());
            modifyStreetNumberInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getStreetNumber());
            modifyDiagnoseInputField.setText(patientsTable.getSelectionModel().getSelectedItem().getDiagnose());
        }
    }

    @FXML
    public void modifyButtonPushed(ActionEvent event){
        if (!isAllFilledModify()){
            ModifyMessageFailed("Minden mezőt kötelező kitölteni!");
            return;
        }

        if (!modifyZipcodeInputField.getText().matches("[0-9]+") || !modifyInsuranceIdInputField.getText().matches("[0-9]+") || !modifyStreetNumberInputField.getText().matches("[0-9]+")){
            ModifyMessageFailed("Az irányítószám, házszám és tajszám\n mezők csak számokat tartalmazhatnak!");
            return;
        }
        if(modifyInsuranceIdInputField.getText().length() != 9){
            ModifyMessageFailed("A tajszám 9 számot tartalmaz!");
            return;
        }
        if(!isValidBirthDate(modifyBirthDateInputField.getText())){
            ModifyMessageFailed("Helytelen születési dátum!\nHelyes formátum: ÉÉÉÉ-HH-NN");
            return;
        }
        if (!modiyfNameInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+") || !modifyMotherNameInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+") || !modifyCityInputField.getText().matches("[[a-zA-Z]+ÉÁÖÜÓŐÚŰÍéáöüóőúűí]+") || !modifyStreetInputField.getText().matches("[/^[a-zA-ZáéíöüóőúűÉÁÖÜÓŐÚŰÍ ,.'-]+$/u]+"))
        {
            ModifyMessageFailed("A Név, Anyja neve, Város és Utca mezők\n csak betűket tartalmazhatnak!");
            return;
        }

        try(JPAPatientDAO aDAO = new JPAPatientDAO()){

            List<Patient> patients = aDAO.getPatients();
            boolean modify = false;
            for (Patient p : patients){
                if (p.getCardNumber() == Integer.parseInt(modifyCardnumInputField.getText())){

                    if (!(p.getName().matches(modiyfNameInputField.getText()))) {
                        p.setName(modiyfNameInputField.getText());
                        modify = true;
                    }

                    if (!(p.getNameOfMother().matches(modifyMotherNameInputField.getText()))) {
                        p.setNameOfMother(modifyMotherNameInputField.getText());
                        modify = true;
                    }

                    if (p.getSocialInsuranceId() != Integer.parseInt(modifyInsuranceIdInputField.getText())) {
                        p.setSocialInsuranceId(Integer.parseInt(modifyInsuranceIdInputField.getText()));
                        modify = true;
                    }

                    if (!(p.getBirthDate().matches(modifyBirthDateInputField.getText()))) {
                        p.setBirthDate(modifyBirthDateInputField.getText());
                        modify = true;
                    }

                    if (!(p.getDiagnose().matches(modifyDiagnoseInputField.getText()))) {
                        p.setDiagnose(modifyDiagnoseInputField.getText());
                        modify = true;
                    }

                    if (p.getZipCode() != Integer.parseInt(modifyZipcodeInputField.getText())) {
                        p.setZipCode(Integer.parseInt(modifyZipcodeInputField.getText()));
                        modify = true;
                    }

                    if (!(p.getCity().matches(modifyCityInputField.getText()))) {
                        p.setCity(modifyCityInputField.getText());
                        modify = true;
                    }

                    if (!(p.getStreet().matches(modifyStreetInputField.getText()))) {
                        p.setStreet(modifyStreetInputField.getText());
                        modify = true;
                    }

                    if (!(p.getStreetNumber().matches(modifyStreetNumberInputField.getText()))) {
                        p.setStreetNumber(modifyStreetNumberInputField.getText());
                        modify = true;
                    }

                    if (!modify){
                        ModifyMessageSuccess("Nem történt módosítás!");
                        clearTexts();
                        return;
                    }

                    aDAO.updatePatient(p);
                }
            }

            patientsTable.setItems(listPatientsToUI());
            ModifyMessageSuccess("Sikeres módosítás!");
            clearTexts();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private boolean isAllFilledModify() {
        if(modiyfNameInputField.getText() == null || modiyfNameInputField.getText().trim().isEmpty()) return false;
        if(modifyCityInputField.getText() == null || modifyCityInputField.getText().trim().isEmpty()) return false;
        if(modifyZipcodeInputField.getText() == null || modifyZipcodeInputField.getText().trim().isEmpty()) return false;
        if(modifyStreetInputField.getText() == null || modifyStreetInputField.getText().trim().isEmpty()) return false;
        if(modifyInsuranceIdInputField.getText() == null || modifyInsuranceIdInputField.getText().trim().isEmpty()) return false;
        if(modifyCardnumInputField.getText() == null || modifyCardnumInputField.getText().trim().isEmpty()) return false;
        if(modifyDiagnoseInputField.getText() == null || modifyDiagnoseInputField.getText().trim().isEmpty()) return false;
        if(modifyBirthDateInputField.getText() == null || modifyBirthDateInputField.getText().trim().isEmpty()) return false;
        if(modifyMotherNameInputField.getText() == null || modifyMotherNameInputField.getText().trim().isEmpty()) return false;
        if(modifyStreetNumberInputField.getText() == null || modifyStreetNumberInputField.getText().trim().isEmpty()) return false;

        return true;

    }

    public void ConfirmButton_SelectPatientLabel_Action(ActionEvent event){
        SelectPatientLabel.setText("A lekérdezéshez válasszon ki egy beteget!");
        DiagnoseLabel.setText("");
        Diagnoses.setText("");
        ConfirmButton_SelectPatientLabel.setOpacity(0);
    }

    private void clearTexts() {
        nameInputField.setText("");
        cityInputField.setText("");
        zipcodeInputField.setText("");
        streetInputField.setText("");
        insuranceIdInputField.setText("");
        cardnumInputField.setText("");
        diagnoseInputField.setText("");
        birthdateInputField.setText("");
        motherNameInputField.setText("");
        streetNumberInputField.setText("");
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        //modify
        modiyfNameInputField.setText("");
        modifyCityInputField.setText("");
        modifyZipcodeInputField.setText("");
        modifyStreetInputField.setText("");
        modifyInsuranceIdInputField.setText("");
        modifyCardnumInputField.setText("");
        modifyDiagnoseInputField.setText("");
        modifyBirthDateInputField.setText("");
        modifyMotherNameInputField.setText("");
        modifyStreetNumberInputField.setText("");

    }

    private boolean isAllFilled(){
        if(nameInputField.getText() == null || nameInputField.getText().trim().isEmpty()) return false;
        if(cityInputField.getText() == null || cityInputField.getText().trim().isEmpty()) return false;
        if(zipcodeInputField.getText() == null || zipcodeInputField.getText().trim().isEmpty()) return false;
        if(streetInputField.getText() == null || streetInputField.getText().trim().isEmpty()) return false;
        if(insuranceIdInputField.getText() == null || insuranceIdInputField.getText().trim().isEmpty()) return false;
        if(cardnumInputField.getText() == null || cardnumInputField.getText().trim().isEmpty()) return false;
        if(diagnoseInputField.getText() == null || diagnoseInputField.getText().trim().isEmpty()) return false;
        if(birthdateInputField.getText() == null || birthdateInputField.getText().trim().isEmpty()) return false;
        if(motherNameInputField.getText() == null || motherNameInputField.getText().trim().isEmpty()) return false;
        if(streetNumberInputField.getText() == null || streetNumberInputField.getText().trim().isEmpty()) return false;
        if (!radioMale.isSelected() && !radioFemale.isSelected()) return false;

        return true;
    }

    private void MessageFailed(String message){
        SuccesPatient.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(215, 117, 117, 0.8);\n" +
                "\t-fx-border-color: red;\n" +
                "\t-fx-border-width:2px;");
        SuccesPatient.setText(message);
    }

    private void SearchPatientSuccess(String messageRemove){
        RemoveSuccesPatient.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(116, 214, 137, 0.8);\n" +
                "\t-fx-border-color: green;\n" +
                "\t-fx-border-width:2px;");
        RemoveSuccesPatient.setText(messageRemove);
    }

    private void SearchPatientFailed(String messageRemove){
        RemoveSuccesPatient.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(215, 117, 117, 0.8);\n" +
                "\t-fx-border-color: red;\n" +
                "\t-fx-border-width:2px;");
        RemoveSuccesPatient.setText(messageRemove);
    }

    private void MessageSuccess(String messageSuccess){
        SuccesPatient.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(116, 214, 137, 0.8);\n" +
                "\t-fx-border-color: green;\n" +
                "\t-fx-border-width:2px;");
        SuccesPatient.setText(messageSuccess);
    }

    private void ModifyMessageSuccess(String modifyMessage){
        ModifyMessage.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(116, 214, 137, 0.8);\n" +
                "\t-fx-border-color: green;\n" +
                "\t-fx-border-width:2px;");
        ModifyMessage.setText(modifyMessage);
    }

    private void ModifyMessageFailed(String modifyMessage){
        ModifyMessage.setStyle("" +
                "-fx-font-weight:bold;\n" +
                "\t-fx-background-color:rgba(215, 117, 117, 0.8);\n" +
                "\t-fx-border-color: red;\n" +
                "\t-fx-border-width:2px;");
        ModifyMessage.setText(modifyMessage);
    }

    private boolean isValidBirthDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate birthdate = LocalDate.parse(date, formatter);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
