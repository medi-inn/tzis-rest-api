package com.msr.tzis;

import com.msr.tzis.model.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final KabineRepository kabineRep;
    private final DesktopRepository desktopRep;
    private final ItemLineRepository itemLineRep;
    private final OrderRepository orderRep;
    private final ItemRepository itemRep;

    public DataLoader(KabineRepository kabineRep, DesktopRepository desktopRep, ItemLineRepository itemLineRep, OrderRepository orderRep, ItemRepository itemRep){
        this.kabineRep = kabineRep;
        this.desktopRep = desktopRep;
        this.itemLineRep = itemLineRep;
        this.orderRep = orderRep;
        this.itemRep = itemRep;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        /*
        desktopRep.save(new Desktop("Frontdesk", true, false));
        desktopRep.save(new Desktop("Backoffice", false, true));
        kabineRep.save(new Kabine("Kabine 1"));
        kabineRep.save(new Kabine("Kabine 2"));
        */
    }
}
