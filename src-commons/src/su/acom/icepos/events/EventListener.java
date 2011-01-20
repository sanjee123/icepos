/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.events;

/**
 *
 * @author az
 */
public class EventListener {
    public Object object;
    public String handlerName;
    public EventListener(Object object, String handlerName) {
        this.object      = object;
        this.handlerName = handlerName;
    }
}
