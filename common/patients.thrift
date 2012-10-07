namespace java com.tapink.doctornfc.patients
namespace py patients

typedef string ObjectID
typedef string NFCID

struct Patient {
    1:ObjectID id,
    2:NFCID tag_id,
    3:string first_name,
    4:string last_name,
}

struct Medication {
    1:ObjectID id,
    2:NFCID tag_id,
    3:string name,
    4:string type,
    5:list<string> side_effects,
    6:list<string> interacting_drug_ids
}

struct Prescription {
    1:ObjectID id,
    2:NFCID tag_id,
    3:ObjectID patient_id,
    4:string medication_name,
    5:string medication_type,
    6:i32 tablets,
    7:i32 tablet_size,
    8:i32 hours_between_doses,
}

service MedicationService {
    // Patients
    bool add_patient(1:Patient patient),
    bool remove_patient(1:Patient patient),
    list<Patient> get_patients()
    Patient get_patient_by_tag_id(1:NFCID tag_id)

    // Medications
    bool add_medication(1:Medication medication),
    bool remove_medication(1:Medication medication),
    list<Medication> get_medications()
    Medication get_medication_by_tag_id(1:NFCID tag_id)

    // Prescriptions
    bool add_prescription(1:Prescription prescription),
    bool remove_prescription(1:Prescription prescription),
    Prescription get_prescription_by_tag_id(1:NFCID tag_id)
    list<Prescription> get_prescriptions_for_patient(1:ObjectID patient_id)
}
