
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00am (midnight) to 11:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Daisry Joy Ladignon
 * @version 2018.09.27
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;  
    private String meridian;// simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        meridian = ""; 
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        meridian = ""; 
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {             
        
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + meridian;
      
    }
    
    public String get12HourInternalDisplay()
    {
        int hour = hours.getValue();  
       
        if(hour >= 12 && hour < 24) {
            meridian = "pm";
        }
        else {
            meridian = "am";
        } 
        
        if(hours.getValue() > 12)
            setTime((hours.getValue() %12), minutes.getValue());
        else if (hours.getValue() <= 12){
            
        if (hours.getValue() %12 == 0)
             setTime(12, minutes.getValue()); 
             
        else setTime(hours.getValue(), minutes.getValue());
            }
 
        
         return displayString;
       
    }
    
}
