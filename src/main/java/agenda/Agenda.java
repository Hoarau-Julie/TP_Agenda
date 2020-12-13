package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    public LinkedList<Event> events = new LinkedList<>() ; 
    
    
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        // TODO 
        events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO 
        LinkedList<Event> ListEventsInDay = new LinkedList<>();
        for(Event e : this.events){
            if( e.isInDay(day) ){
                ListEventsInDay.add(e);
            }
        }
        return ListEventsInDay;
    }
    
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        // TODO 
        LinkedList<Event> ListEventsSameTitle = new LinkedList<>(); 
         for(Event e : this.events){
            if(e.getTitle().equals(title)){
                ListEventsSameTitle.add(e);
            }
        }
        return ListEventsSameTitle;
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        // TODO : implémenter cette méthode
        if(events.isEmpty())
        {
            return true;
        }
        for (Event event : events){
           
            if(event.getStart().plus(event.getDuration()).isAfter(e.getStart()) && event.getStart().isBefore(e.getStart().plus(e.getDuration())))
            {
                return false;
            } 
        }
        return true;
    }
    
}
