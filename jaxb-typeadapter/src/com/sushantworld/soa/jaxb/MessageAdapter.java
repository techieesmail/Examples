package com.sushantworld.soa.jaxb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sushantworld.soa.domain.Message;
import com.sushantworld.soa.domain.Messages1;

public class MessageAdapter extends XmlAdapter<Messages1,Map<String, Message>> {
    @Override
    public Map<String, Message> unmarshal( Messages1 value ){
    	Map<String, Message> map = new HashMap<String, Message>();
        for( Message msg : value.messages )
            map.put( msg.getId(), msg );
        return map;
    }  

    @Override
    public Messages1 marshal( Map<String, Message> map ){
        Messages1 msgCont = new Messages1();
        Collection<Message> msgs = map.values();
        msgCont.messages = msgs.toArray(new Message[msgs.size()]);
        return msgCont;
    }
}
