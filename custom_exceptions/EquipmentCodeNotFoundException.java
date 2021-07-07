package custom_exceptions;

public class EquipmentCodeNotFoundException extends Exception {

    public EquipmentCodeNotFoundException() { super("Can not find the equipment with this code."); }
}
