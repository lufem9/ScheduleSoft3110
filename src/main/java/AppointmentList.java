public class AppointmentList {

    public int count;
    public Appointment aArr[] = new Appointment[10];

    public void addAppointment(Appointment a)
    {
        aArr[count] = a;
        count++;
    }
    public int getCount()
    {
        return count;
    }
    public Appointment getAppointment(int a)
    {
        return aArr[a];
    }

    public void display()
    {
        System.out.println("starting to display list");
        for(int x =0; x< count; x++)
        {
            //aArr[x].display();
        }
    }

}
