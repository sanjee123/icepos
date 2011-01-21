/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.events;

import java.lang.reflect.Method;

/**
 *
 * @author az
 */
public class EventListener {
    public Object object;
    private String handlerName;
    private Method m_methodRef;

    public EventListener(Object object, String handlerName, Method methodRef) {
        this.object      = object;
        this.handlerName = handlerName;
        m_methodRef = methodRef;
    }

    public Method getListenerFunc() {
        return m_methodRef;
    }
}
