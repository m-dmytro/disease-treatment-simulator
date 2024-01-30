# Problem Description
You were asked by a doctor to prepare a Hospital Simulator, which can simulate the future patients’ health state, based on their current health state and a list of drugs they are administered.
Patients can have one of these states:
* F : Fever
* H : Healthy
* D : Diabetes
* T : Tuberculosis
* X : Dead'

In the Hospital Simulator drugs are provided to all patients. It is not possible to target a specific patient. This is the list of available drugs:
* As : Aspirin
* An : Antibiotic
* I  : Insulin
* P  : Paracetamol

Drugs can change patients’ states. They can cure, cause side effects or even kill a patient if not properly prescribed.
Drug effects are described by the following rules:
* Aspirin cures Fever
* Antibiotic cures Tuberculosis
* Insulin prevents diabetic subjects from dying, does not cure Diabetes
* Insulin mixed with Antibiotic causes Healthy people to catch Fever
* Paracetamol cures Fever
* Paracetamol kills subjects if mixed with Aspirin
* One time in a million the Flying Spaghetti Monster shows his noodly power and resurrects a Dead patient, the patient becomes Healthy

# Examples
## Example #1
    Input   : D,D
    Output  : F:0,H:0,D:0,T:0,X:2
    Comment : Diabetic patients die without Insulin.
## Example #2
    Input   : F P
    Output  : F:0,H:1,D:0,T:0,X:0
    Comment : Paracetamol cures Fever.
## Example #3
    Input   : T,F,D An,I
    Output  : F:2,H:0,D:1,T:0,X:0
    Comment : Insulin prevents Diabetic patient from dying, Antibiotics cure Tuberculosis, but in combination with Insulin causes Healthy people to catch Fever.

# Run
* as SpringBootApplication from your IDE
* as jar file: java -jar path-to-file/disease-treatment-simulator-0.0.1-SNAPSHOT.jar
* follow CLI instructions and enter desired task, e.g.: T,F,D An,I

