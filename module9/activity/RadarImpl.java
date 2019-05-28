package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of a Radar
 */
public class RadarImpl implements Radar {

    List radar = new ArrayList();

    /**
     * Constructs a new Radar
     */
    public RadarImpl() {
    }


    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
     */
    public RadarContact addContact(RadarContactImpl contact) {
        this.radar.add(contact);
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContact(java.lang.String)
     */
    public RadarContact getContact(String id) {
        int i = 0;
        while (i < this.radar.size()) {
            if (((RadarContact) this.radar.get(i)).getContactID().equals(id)) {
                return (RadarContact) this.radar.get(i);
            }
            i++;
            //return this.radar.get(id);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContactCount()
     */
    public int getContactCount() {
        return this.radar.size();
    }

    @Override
    public RadarContact addContact(RadarContact contact) {
        //RadarContactImpl temp = new RadarContactImpl(contact.getContactID(), contact.getBearing(), contact.getDistance());
        boolean sucsess = this.radar.add(contact);
        if (sucsess) {
            return contact;
        }
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#removeContact(java.lang.String)
     */
    public RadarContact removeContact(String id) {
        if (this.radar.contains(getContact(id))) {
            RadarContact temp = (RadarContact) this.radar.get(this.radar.indexOf(getContact(id)));
            boolean removing = this.radar.remove(getContact(id));
            if (removing) {
                return temp;
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts()
     */
    public List<RadarContact> returnContacts() {
        List copy = new ArrayList();
        int i = 0;
        while (i < this.radar.size()) {
            copy.add(this.radar.get(i));
            i++;
        }
        return copy;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
     */
    public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
        List copy = new ArrayList();
        int i = 1;
        int j = 0;
        copy.add(this.radar.get(0));
        while (i < this.radar.size()) {
            j = 0;
            while (j < copy.size()) {
                if (comparator.compare((RadarContact) this.radar.get(i), (RadarContact) copy.get(j)) <= 0) {
                    copy.add(j, this.radar.get(i));
                    break;
                }
                j++;
            }
            if (copy.size()==i){
                copy.add(this.radar.get(i));
            }
            i++;
        }
        return copy;
    }
}
