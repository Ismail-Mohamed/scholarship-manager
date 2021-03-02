package com.views.controllers;

import com.dbcontrollers.DemandController;
import com.helpers.AlertHelper;
import com.helpers.DateHelper;
import com.helpers.Validations;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.models.Demand;
import com.tableModels.DemandTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class CandidateController implements Initializable {

    @FXML
    private ToggleGroup genderRBG;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private JFXTextField fullNameFrField;
    @FXML
    private JFXTextField fullNameArField;
    @FXML
    private JFXTextField budgetField;
    @FXML
    private JFXTextField ticketPriceField;
    @FXML
    private JFXComboBox<String> scholarshipTypeComboBox;
    @FXML
    private JFXTextField dobField;
    @FXML
    private JFXComboBox<String> financialYearComboBox;
    @FXML
    private JFXComboBox<String> beneficiaryComboBox;
    @FXML
    private JFXComboBox<String> domainComboBox;
    @FXML
    private JFXTextField beginDateField;
    @FXML
    private JFXComboBox<String> gradeComboBox;
    @FXML
    private JFXComboBox<String> facultyComboBox;
    @FXML
    private JFXTextField endDateField;
    @FXML
    private JFXTextField durationField;
    @FXML
    private JFXComboBox<String> countryComboBox;
    @FXML
    private JFXTextField laboratoryField;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton print;
    @FXML
    private JFXButton reset;


    private String id;
    private String editTextButton = "Ajouter";
    private String gender = "M";
    private String fullNameFr;
    private String fullNameAr;
    private String budget;
    private String ticketPrice;
    private String scholarshipType;
    private String dob;
    private String beneficiary = "Professeur";
    private String domain;
    private String beginDate;
    private String grade;
    private String faculty;
    private String endDate;
    private long duration = 0;
    private String country;
    private String laboratory;
    private String financialYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));


    public void initialize(URL url, ResourceBundle resourceBundle) {
        beneficiaryComboBox.getItems().addAll("Professeur", "Employé", "Étudiant");
        facultyComboBox.getItems().addAll("DROIT ET SCIENCES POLITIQUES", "GENIE CIVIL ET D'ARCHITECTURE", "INSTITUT STAPS", "LETTERS ET DES LANGUES ", "MEDECINE", "SCIENCES", "SCIENCES ECONOMQUE COMMERCIALES ET SCIENCES DE GESTIONS", "SCIENCES HUMAINES ISLAMIQUE ET CIVILISATION", "TECHNOLOGIE");
        countryComboBox.getItems().addAll("Afrique du Sud", "Allemagne", "Arabie Saoudite", "atar", "Bahreïn", "Belgique", "Brésil", "Canada", "Chili", "Chine", "Emirate Arabs Unis", "Espagne", "Etats-Unis d'Amérique", "Finlande", "France", "gypte", "Hollande", "Hongrie", "Ile Maurice", "Italie", "Jordanie", "Koweït", "Liban", "Malaisie", "Malaysia", "Maroc", "Oman", "Portugal", "Royaume-Uni", "Russie", "Stockholm", "Suisse", "Tchèque", "Tunisie", "Turquie");
        domainComboBox.getItems().addAll("S.T", "A.U.M.V", "M.I", "S.M", "S.N.V", "S.E.C.G", "D.S.P", "L L A", "L L E", "S.S.H", "STAPS", "SC.MEDICALES");
        scholarshipTypeComboBox.getItems().addAll("Longue", "Court");
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        financialYearComboBox.getItems().addAll(String.valueOf(currentYear), String.valueOf(currentYear - 1));
        financialYearComboBox.getSelectionModel().select(0);
        financialYearComboBox.setEditable(true);
        beneficiaryComboBox.getSelectionModel().select(0);
        facultyComboBox.getSelectionModel().select(0);
        countryComboBox.getSelectionModel().select(0);
        beneficiaryComboBox.getSelectionModel().select(beneficiary);
        loadGrades();
        beneficiaryComboBox.setOnAction(e -> {
            loadGrades();
        });
        endDateField.focusedProperty().addListener(e -> {
            if (beginDateField.getText() != null && endDateField.getText() != null && !endDateField.isFocused() && Validations.validateDate(beginDateField) && Validations.validateDate(endDateField)) {
                DateTimeException dateTimeException = null;
                long diff = 0;
                try {
                    LocalDate begin = LocalDate.parse(DateHelper.format(beginDateField.getText()));
                    LocalDate end = LocalDate.parse(DateHelper.format(endDateField.getText()));
                    diff = ChronoUnit.DAYS.between(begin, end);
                    if (diff < 0) {
                        dateTimeException = new DateTimeException("date beign gater then date end");
                        throw dateTimeException;
                    }

                    durationField.setText(String.valueOf(diff));
                    if (diff > 7) {
                        scholarshipTypeComboBox.getSelectionModel().select("Longue");
                    } else {
                        scholarshipTypeComboBox.getSelectionModel().select("Court");
                    }
                } catch (DateTimeException Exception) {
                    if (diff < 0)
                        AlertHelper.makeAlert("Erreur : Date invalide..!", "La date de depart superieur a la date d'arriver");
                    else
                        AlertHelper.makeAlert("Erreur : Date invalide..!", "Date invalide..!");

                }
            }
        });
        //onAction event
        add.setOnAction(addEvent);
        print.setOnAction(printEvent);
        reset.setOnAction(resetEvent);
        initialiseFields();

    }

    private void loadGrades() {
        ArrayList<String> arrayList = new ArrayList<>();
        String beneficiaryValue = beneficiaryComboBox.getSelectionModel().getSelectedItem();
        switch (beneficiaryValue) {
            case "Professeur": {
                arrayList.add("PROF");
                arrayList.add("MCA");
                arrayList.add("MCB");
                arrayList.add("MAA");
                arrayList.add("MAB");
                arrayList.add("MC HU A");
                arrayList.add("MC HU B");
                arrayList.add("MA HU");
                ObservableList list = FXCollections.observableArrayList(arrayList);
                gradeComboBox.setItems(list);
                gradeComboBox.getSelectionModel().select("PROF");
                break;
            }
            case "Employé": {
                arrayList.add("EXECECUTION");
                arrayList.add("MAITRISE");
                arrayList.add("APPLICATION");
                ObservableList list = FXCollections.observableArrayList(arrayList);
                gradeComboBox.setItems(list);
                gradeComboBox.getSelectionModel().select("EXECECUTION");
                break;

            }
            case "Étudiant": {
                arrayList.add("ETUD DLMD");
                arrayList.add("ETUD MASTER");
                ObservableList list = FXCollections.observableArrayList(arrayList);
                gradeComboBox.setItems(list);
                gradeComboBox.getSelectionModel().select("ETUD DLMD");
                break;
            }
        }

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFullNameFr(String fullNameFr) {
        this.fullNameFr = fullNameFr;
    }

    public void setFullNameAr(String fullNameAr) {
        this.fullNameAr = fullNameAr;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public void setEditTextButton(String editTextButton) {
        this.editTextButton = editTextButton;
    }

    public void setId(String id) {
        this.id = id;
    }

    EventHandler<ActionEvent> resetEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            clearAllField();
        }
    };
    @FXML
    EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            if (Validations.validateEmpty(fullNameFrField) && Validations.validateEmpty(fullNameArField) && Validations.validateEmpty(budgetField) && Validations.validateEmpty(ticketPriceField) && Validations.validateEmpty(dobField) && Validations.validateEmpty(beginDateField) && Validations.validateEmpty(endDateField) && Validations.validateDate(dobField) && Validations.validateDate(beginDateField) && Validations.validateDate(endDateField) && Validations.validateEmpty(laboratoryField) && Validations.validateEmpty(budgetField) && Validations.validateEmpty(ticketPriceField) && Validations.validateFloat(budgetField) && Validations.validateFloat(ticketPriceField)) {

                try {
                    LocalDate dob = LocalDate.parse(DateHelper.format(dobField.getText()));
                    LocalDate beginDate = LocalDate.parse(DateHelper.format(beginDateField.getText()));
                    LocalDate endDate = LocalDate.parse(DateHelper.format(endDateField.getText()));

                    fullNameAr = fullNameFrField.getText();
                    fullNameFr = fullNameArField.getText();
                    budget = budgetField.getText();
                    ticketPrice = ticketPriceField.getText();

                    duration = Long.parseLong(durationField.getText());
                    laboratory = laboratoryField.getText();
                    if (countryComboBox.getSelectionModel().getSelectedItem() == null)
                        countryComboBox.getSelectionModel().select(0);
                    country = countryComboBox.getSelectionModel().getSelectedItem();
                    if (gradeComboBox.getSelectionModel().getSelectedItem() == null)
                        gradeComboBox.getSelectionModel().select(0);
                    grade = gradeComboBox.getSelectionModel().getSelectedItem();
                    if (scholarshipTypeComboBox.getSelectionModel().getSelectedItem() == null)
                        scholarshipTypeComboBox.getSelectionModel().select(0);
                    scholarshipType = scholarshipTypeComboBox.getSelectionModel().getSelectedItem();
                    if (beneficiaryComboBox.getSelectionModel().getSelectedItem() == null)
                        beneficiaryComboBox.getSelectionModel().select(0);
                    beneficiary = beneficiaryComboBox.getSelectionModel().getSelectedItem();
                    if (domainComboBox.getSelectionModel().getSelectedItem() == null)
                        domainComboBox.getSelectionModel().select(0);
                    domain = domainComboBox.getSelectionModel().getSelectedItem();
                    if (financialYearComboBox.getSelectionModel().getSelectedItem() == null)
                        financialYearComboBox.getSelectionModel().select(0);
                    financialYear = financialYearComboBox.getSelectionModel().getSelectedItem();
                    if (facultyComboBox.getSelectionModel().getSelectedItem() == null)
                        facultyComboBox.getSelectionModel().select(0);
                    faculty = facultyComboBox.getSelectionModel().getSelectedItem();

                    if (maleRadioButton.isSelected()) {
                        gender = "M";
                    } else if (femaleRadioButton.isSelected()) {
                        gender = "F";
                    }
                    Demand demand = new Demand(id, beneficiary, fullNameAr, fullNameFr, dob.toString(), gender, grade, duration, beginDate.toString(), endDate.toString(), country, laboratory, domain, scholarshipType, budget, ticketPrice, financialYear, faculty);
                    int resultQuery = 0;

                    if (id != null) {
                        resultQuery = DemandController.update(demand);
                    } else {
                        resultQuery = DemandController.create(demand);
                    }
                    if (resultQuery > 0) {
                        clearAllField();
                        AlertHelper.makeAlert("Message de réussite", "votre demande a été ajoutée avec succès");
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                } catch (DateTimeException Exception) {
                    AlertHelper.makeAlert("Erreur : Date invalide..!", "Date invalide..!");

                }

            }
        }
    };
    @FXML
    EventHandler<ActionEvent> printEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {

//            if (false) {
//                try {
//
//                    InputStream StudentAdmissionReport = getClass().getResourceAsStream("/reports/StudentAdmission.jrxml");
//                    JRDesignQuery query = new JRDesignQuery();
//                    //bloc code for report view
//                    if (StudentAdmissionReport != null) {
//                        JasperDesign jd = JRXmlLoader.load(StudentAdmissionReport);
//                        query.setText("SELECT * FROM students WHERE id = '" + selectedItem.getId() + "'");
//                        jd.setQuery(query);
//                        dbControllers.ReportViewController r = new dbControllers.ReportViewController();
//                        r.viewReport(jd);
//                    }
//                } catch (JRException e) {
//                    e.printStackTrace();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
        }
    };

    private void clearAllField() {
        fullNameFrField.setText(null);
        fullNameArField.setText(null);
        budgetField.setText(null);
        ticketPriceField.setText(null);
        dobField.setText(null);
        beginDateField.setText(null);
        endDateField.setText(null);
        durationField.setText(null);
        laboratoryField.setText(null);
        countryComboBox.getSelectionModel().select(0);
        gradeComboBox.getSelectionModel().select(0);
        scholarshipTypeComboBox.getSelectionModel().select(0);
        beneficiaryComboBox.getSelectionModel().select(0);
        domainComboBox.getSelectionModel().select(0);
        facultyComboBox.getSelectionModel().select(0);
        maleRadioButton.setSelected(true);
    }

    private void initialiseFields() {
        durationField.setEditable(false);
        fullNameFrField.setText(fullNameFr);
        fullNameArField.setText(fullNameAr);
        budgetField.setText(budget);
        ticketPriceField.setText(ticketPrice);
        dobField.setText(dob);
        beginDateField.setText(beginDate);
        endDateField.setText(endDate);
        durationField.setText(String.valueOf(duration));
        laboratoryField.setText(laboratory);

        countryComboBox.getSelectionModel().select(country);
        gradeComboBox.getSelectionModel().select(grade);
        scholarshipTypeComboBox.getSelectionModel().select(scholarshipType);
        domainComboBox.getSelectionModel().select(domain);
        facultyComboBox.getSelectionModel().select(faculty);
        if (financialYear != null)
            financialYearComboBox.getItems().add(financialYear);
        financialYearComboBox.getSelectionModel().select(financialYear);
        add.setText(editTextButton);
        if (duration > 7) {
            scholarshipTypeComboBox.getSelectionModel().select("Longue");
        } else {
            scholarshipTypeComboBox.getSelectionModel().select("Court");
        }
        if (gender.equals("M")) {
            maleRadioButton.setSelected(true);
        } else if (gender.equals("F")) {
            femaleRadioButton.setSelected(true);
        }

    }


}
