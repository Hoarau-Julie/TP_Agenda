package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    
    protected ChronoUnit myFrequency;
   
    private final ArrayList<LocalDate> Exceptions = new ArrayList<>();
    
    
    public LinkedList<Event> events = new LinkedList<>() ;
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        
        this.myFrequency = frequency;
    }
    
    @Override
    public boolean isInDay(LocalDate date){
        if(Exceptions.contains(date)){
            return false;
        }
        LocalDateTime closestStart = this.getStart();
        
        LocalDateTime lastFinish = closestStart.plus(this.getDuration());
        
        while(lastFinish.toLocalDate().isBefore(date) && !closestStart.plus(1,myFrequency).toLocalDate().isAfter(date))
        {
            closestStart = closestStart.plus(1,myFrequency);
            lastFinish = closestStart.plus(this.getDuration());
        }
        if(date.isEqual(closestStart.toLocalDate()) || date.isEqual(lastFinish.toLocalDate())){
            return true;
        }
        else if(date.isAfter(closestStart.toLocalDate()) && date.isBefore(lastFinish.toLocalDate())){
            return true;
        }
        return false;
    }
    
    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
   
    public void addException(LocalDate date) {
        // TODO : implémenter cette méthode
        Exceptions.add(date); 
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // TODO 
        return this.myFrequency;
    }
}