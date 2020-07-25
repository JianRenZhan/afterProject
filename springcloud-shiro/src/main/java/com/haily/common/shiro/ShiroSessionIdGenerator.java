package com.haily.common.shiro;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ShiroSessionIdGenerator implements SessionIdGenerator {

    private static final Logger log = LoggerFactory.getLogger(ShiroSessionIdGenerator.class);

    /**
     * 实现SessionId生成
     */
    @Override
    public Serializable generateId(Session session) {
        log.debug("ShiroSessionIdGenerator - generateId=======================================");
        Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s",sessionId);
    }
}
