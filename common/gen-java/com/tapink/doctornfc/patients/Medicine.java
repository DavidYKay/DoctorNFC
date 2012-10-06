/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tapink.doctornfc.patients;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Medicine implements org.apache.thrift.TBase<Medicine, Medicine._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Medicine");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SIDE_EFFECTS_FIELD_DESC = new org.apache.thrift.protocol.TField("side_effects", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField INTERACTING_DRUG_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("interacting_drug_names", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MedicineStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MedicineTupleSchemeFactory());
  }

  public String name; // required
  public String type; // required
  public List<String> side_effects; // required
  public List<String> interacting_drug_names; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    TYPE((short)2, "type"),
    SIDE_EFFECTS((short)3, "side_effects"),
    INTERACTING_DRUG_NAMES((short)4, "interacting_drug_names");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // TYPE
          return TYPE;
        case 3: // SIDE_EFFECTS
          return SIDE_EFFECTS;
        case 4: // INTERACTING_DRUG_NAMES
          return INTERACTING_DRUG_NAMES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SIDE_EFFECTS, new org.apache.thrift.meta_data.FieldMetaData("side_effects", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.INTERACTING_DRUG_NAMES, new org.apache.thrift.meta_data.FieldMetaData("interacting_drug_names", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Medicine.class, metaDataMap);
  }

  public Medicine() {
  }

  public Medicine(
    String name,
    String type,
    List<String> side_effects,
    List<String> interacting_drug_names)
  {
    this();
    this.name = name;
    this.type = type;
    this.side_effects = side_effects;
    this.interacting_drug_names = interacting_drug_names;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Medicine(Medicine other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetSide_effects()) {
      List<String> __this__side_effects = new ArrayList<String>();
      for (String other_element : other.side_effects) {
        __this__side_effects.add(other_element);
      }
      this.side_effects = __this__side_effects;
    }
    if (other.isSetInteracting_drug_names()) {
      List<String> __this__interacting_drug_names = new ArrayList<String>();
      for (String other_element : other.interacting_drug_names) {
        __this__interacting_drug_names.add(other_element);
      }
      this.interacting_drug_names = __this__interacting_drug_names;
    }
  }

  public Medicine deepCopy() {
    return new Medicine(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.type = null;
    this.side_effects = null;
    this.interacting_drug_names = null;
  }

  public String getName() {
    return this.name;
  }

  public Medicine setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getType() {
    return this.type;
  }

  public Medicine setType(String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public int getSide_effectsSize() {
    return (this.side_effects == null) ? 0 : this.side_effects.size();
  }

  public java.util.Iterator<String> getSide_effectsIterator() {
    return (this.side_effects == null) ? null : this.side_effects.iterator();
  }

  public void addToSide_effects(String elem) {
    if (this.side_effects == null) {
      this.side_effects = new ArrayList<String>();
    }
    this.side_effects.add(elem);
  }

  public List<String> getSide_effects() {
    return this.side_effects;
  }

  public Medicine setSide_effects(List<String> side_effects) {
    this.side_effects = side_effects;
    return this;
  }

  public void unsetSide_effects() {
    this.side_effects = null;
  }

  /** Returns true if field side_effects is set (has been assigned a value) and false otherwise */
  public boolean isSetSide_effects() {
    return this.side_effects != null;
  }

  public void setSide_effectsIsSet(boolean value) {
    if (!value) {
      this.side_effects = null;
    }
  }

  public int getInteracting_drug_namesSize() {
    return (this.interacting_drug_names == null) ? 0 : this.interacting_drug_names.size();
  }

  public java.util.Iterator<String> getInteracting_drug_namesIterator() {
    return (this.interacting_drug_names == null) ? null : this.interacting_drug_names.iterator();
  }

  public void addToInteracting_drug_names(String elem) {
    if (this.interacting_drug_names == null) {
      this.interacting_drug_names = new ArrayList<String>();
    }
    this.interacting_drug_names.add(elem);
  }

  public List<String> getInteracting_drug_names() {
    return this.interacting_drug_names;
  }

  public Medicine setInteracting_drug_names(List<String> interacting_drug_names) {
    this.interacting_drug_names = interacting_drug_names;
    return this;
  }

  public void unsetInteracting_drug_names() {
    this.interacting_drug_names = null;
  }

  /** Returns true if field interacting_drug_names is set (has been assigned a value) and false otherwise */
  public boolean isSetInteracting_drug_names() {
    return this.interacting_drug_names != null;
  }

  public void setInteracting_drug_namesIsSet(boolean value) {
    if (!value) {
      this.interacting_drug_names = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((String)value);
      }
      break;

    case SIDE_EFFECTS:
      if (value == null) {
        unsetSide_effects();
      } else {
        setSide_effects((List<String>)value);
      }
      break;

    case INTERACTING_DRUG_NAMES:
      if (value == null) {
        unsetInteracting_drug_names();
      } else {
        setInteracting_drug_names((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case TYPE:
      return getType();

    case SIDE_EFFECTS:
      return getSide_effects();

    case INTERACTING_DRUG_NAMES:
      return getInteracting_drug_names();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case TYPE:
      return isSetType();
    case SIDE_EFFECTS:
      return isSetSide_effects();
    case INTERACTING_DRUG_NAMES:
      return isSetInteracting_drug_names();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Medicine)
      return this.equals((Medicine)that);
    return false;
  }

  public boolean equals(Medicine that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_side_effects = true && this.isSetSide_effects();
    boolean that_present_side_effects = true && that.isSetSide_effects();
    if (this_present_side_effects || that_present_side_effects) {
      if (!(this_present_side_effects && that_present_side_effects))
        return false;
      if (!this.side_effects.equals(that.side_effects))
        return false;
    }

    boolean this_present_interacting_drug_names = true && this.isSetInteracting_drug_names();
    boolean that_present_interacting_drug_names = true && that.isSetInteracting_drug_names();
    if (this_present_interacting_drug_names || that_present_interacting_drug_names) {
      if (!(this_present_interacting_drug_names && that_present_interacting_drug_names))
        return false;
      if (!this.interacting_drug_names.equals(that.interacting_drug_names))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Medicine other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Medicine typedOther = (Medicine)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(typedOther.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, typedOther.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSide_effects()).compareTo(typedOther.isSetSide_effects());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSide_effects()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.side_effects, typedOther.side_effects);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInteracting_drug_names()).compareTo(typedOther.isSetInteracting_drug_names());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInteracting_drug_names()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.interacting_drug_names, typedOther.interacting_drug_names);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Medicine(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("side_effects:");
    if (this.side_effects == null) {
      sb.append("null");
    } else {
      sb.append(this.side_effects);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("interacting_drug_names:");
    if (this.interacting_drug_names == null) {
      sb.append("null");
    } else {
      sb.append(this.interacting_drug_names);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MedicineStandardSchemeFactory implements SchemeFactory {
    public MedicineStandardScheme getScheme() {
      return new MedicineStandardScheme();
    }
  }

  private static class MedicineStandardScheme extends StandardScheme<Medicine> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Medicine struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SIDE_EFFECTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.side_effects = new ArrayList<String>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  String _elem2; // required
                  _elem2 = iprot.readString();
                  struct.side_effects.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setSide_effectsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // INTERACTING_DRUG_NAMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.interacting_drug_names = new ArrayList<String>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  String _elem5; // required
                  _elem5 = iprot.readString();
                  struct.interacting_drug_names.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setInteracting_drug_namesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Medicine struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeString(struct.type);
        oprot.writeFieldEnd();
      }
      if (struct.side_effects != null) {
        oprot.writeFieldBegin(SIDE_EFFECTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.side_effects.size()));
          for (String _iter6 : struct.side_effects)
          {
            oprot.writeString(_iter6);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.interacting_drug_names != null) {
        oprot.writeFieldBegin(INTERACTING_DRUG_NAMES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.interacting_drug_names.size()));
          for (String _iter7 : struct.interacting_drug_names)
          {
            oprot.writeString(_iter7);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MedicineTupleSchemeFactory implements SchemeFactory {
    public MedicineTupleScheme getScheme() {
      return new MedicineTupleScheme();
    }
  }

  private static class MedicineTupleScheme extends TupleScheme<Medicine> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Medicine struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetType()) {
        optionals.set(1);
      }
      if (struct.isSetSide_effects()) {
        optionals.set(2);
      }
      if (struct.isSetInteracting_drug_names()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetType()) {
        oprot.writeString(struct.type);
      }
      if (struct.isSetSide_effects()) {
        {
          oprot.writeI32(struct.side_effects.size());
          for (String _iter8 : struct.side_effects)
          {
            oprot.writeString(_iter8);
          }
        }
      }
      if (struct.isSetInteracting_drug_names()) {
        {
          oprot.writeI32(struct.interacting_drug_names.size());
          for (String _iter9 : struct.interacting_drug_names)
          {
            oprot.writeString(_iter9);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Medicine struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.type = iprot.readString();
        struct.setTypeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.side_effects = new ArrayList<String>(_list10.size);
          for (int _i11 = 0; _i11 < _list10.size; ++_i11)
          {
            String _elem12; // required
            _elem12 = iprot.readString();
            struct.side_effects.add(_elem12);
          }
        }
        struct.setSide_effectsIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.interacting_drug_names = new ArrayList<String>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            String _elem15; // required
            _elem15 = iprot.readString();
            struct.interacting_drug_names.add(_elem15);
          }
        }
        struct.setInteracting_drug_namesIsSet(true);
      }
    }
  }

}

