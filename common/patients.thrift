namespace java com.tapink.doctornfc.patients
namespace py patients

//struct Patient {
//    1:string first_name,
//    2:string last_name,
//    3:string email
//}
//
//service PatientService {
//    bool add_patient(1:Patient patient),
//    list<Patient> get_patients()
//}

struct Medication {
    1:string id,
    2:string name,
    3:string type,
    4:list<string> side_effects,
    5:list<string> interacting_drug_ids
}

service MedicationService {
    bool add_medication(1:Medication medication),
    bool remove_medication(1:Medication medication),
    list<Medication> get_medications()
}
