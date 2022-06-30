package assignments.sheet_1;

public class GarageManager{


    public static void main(String[] args){
        GarageManagement gm = new GarageManagement(3, 5);

        String car1LicenseId = "XYZ-123";
        String car2LicenseId = "ABC-456";
        String car3LicenseId = "FGQ-987";

        Ticket car1Ticket = gm.depositCar(car1LicenseId);
        System.out.println("Deposit of car1 " +(car1Ticket != null ? "successful" : "failed"));
        Ticket car2Ticket = gm.depositCar(car2LicenseId);
        System.out.println("Deposit of car2 " + (car2Ticket != null ? "successful" : "failed"));
        Ticket car3Ticket = gm.depositCar(car3LicenseId);
        System.out.println("Deposit of car3 " + (car3Ticket != null ? "successful" : "failed"));



        gm.printTickets();

        boolean pickupCar3 = gm.pickupCar(car3Ticket);
        System.out.println("Pickup of car3 " + (pickupCar3 ? "successful" : "failed"));
        boolean pickupCar2 = gm.pickupCar(car2Ticket);
        System.out.println("Pickup of car2 " + (pickupCar2 ? "successful" : "failed"));
        boolean pickupCar1 = gm.pickupCar(car1Ticket);
        System.out.println("Pickup of car1 " + (pickupCar1 ? "successful" : "failed"));


        gm.printTickets();

        String testLicenseId = "GHJ-753";

        Ticket testTicket = gm.depositCar(testLicenseId);
        System.out.println("Deposit of test car " + (testTicket != null ? "successful" : "failed"));

        Ticket testTicketDuplicate = new Ticket(testTicket.level, testTicket.position, testLicenseId);

        boolean pickupTestCarWithDuplicateTicket = gm.pickupCar(testTicketDuplicate);

        boolean pickupTestCarWithCorrectTicket = gm.pickupCar(testTicket);

        System.out.println("Attempt to pickup testcar using duplicate ticket " + (pickupTestCarWithDuplicateTicket ? "successful" : "failed") + " (" + testTicketDuplicate + ")");
        System.out.println("Attempt to pickup testcar using correct ticket " + (pickupTestCarWithCorrectTicket ? "successful" : "failed") + " (" + testTicket + ")");



    }
    
}
