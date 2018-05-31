/*
 * $Id$
 * Copyright ( c ) 2012 Carefx Corporation. All Rights Reserved.
 * This software is the confidential and proprietary information of Carefx
 * Corporation ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Carefx Corporation or a Carefx
 * authorized reseller (the "License Agreement"). Carefx may make changes to the
 * Confidential Information from time to time. Such Confidential Information may
 * contain errors.
 * EXCEPT AS EXPLICITLY SET FORTH IN THE LICENSE AGREEMENT, CAREFX DISCLAIMS ALL
 * WARRANTIES, COVENANTS, REPRESENTATIONS, INDEMNITIES, AND GUARANTEES WITH
 * RESPECT TO SOFTWARE AND DOCUMENTATION, WHETHER EXPRESS OR IMPLIED, WRITTEN OR
 * ORAL, STATUTORY OR OTHERWISE INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, TITLE, NON-INFRINGEMENT AND FITNESS FOR A
 * PARTICULAR PURPOSE. CAREFX DOES NOT WARRANT THAT END USER'S USE OF THE
 * SOFTWARE WILL BE UNINTERRUPTED, ERROR FREE OR SECURE.
 * CAREFX SHALL NOT BE LIABLE TO END USER, OR ANY OTHER PERSON, CORPORATION OR
 * ENTITY FOR INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY OR CONSEQUENTIAL
 * DAMAGES, OR DAMAGES FOR LOSS OF PROFITS, REVENUE, DATA OR USE, WHETHER IN AN
 * ACTION IN CONTRACT, TORT OR OTHERWISE, EVEN IF CAREFX HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES. CAREFX' TOTAL LIABILITY TO END USER SHALL NOT
 * EXCEED THE AMOUNTS PAID FOR THE CAREFX SOFTWARE BY END USER DURING THE PRIOR
 * TWELVE (12) MONTHS FROM THE DATE IN WHICH THE CLAIM AROSE. BECAUSE SOME
 * STATES OR JURISDICTIONS DO NOT ALLOW LIMITATION OR EXCLUSION OF CONSEQUENTIAL
 * OR INCIDENTAL DAMAGES, THE ABOVE LIMITATION MAY NOT APPLY TO END USER.
 * Copyright version 2.0
 */
package com.xyb.trash.util.commonutil;

import org.slf4j.Logger;

/**
 * 日志工具
 */
public class LogUtil
{
    private Logger logger;
    
    public LogUtil (Logger logger)
    {
        this.logger = logger;
    }
    
    /**
     * 记录error级别的日志
     * @param logInfo 日志信息
     */
    public void errorLog (String logInfo)
    {
        logger.error (logInfo);
    }
    
    /**
     * 记录error级别的日志
     * @param logInfo 日志信息
     * @param t Throwable
     */
    public void errorLog (String logInfo, Throwable t)
    {
        logger.error (logInfo, t);
    }
    
    /**
     * 记录debug级别的日志
     * 
     * @param logInfo 日志信息
     */
    public void debugLog (String logInfo)
    {
        if (logger.isDebugEnabled ())
        {
            logger.debug (logInfo);
        }
    }
    
    /**
     * 记录debug级别的日志
     * 
     * @param logInfo 日志信息
     * @param t Throwable
     */
    public void debugLog (String logInfo, Throwable t)
    {
        if (logger.isDebugEnabled ())
        {
            logger.debug (logInfo, t);
        }
    }
    
    /**
     * 记录info级别的日志
     * 
     * @param logInfo 日志信息
     */
    public void infoLog (String logInfo)
    {
        if (logger.isInfoEnabled ())
        {
            logger.info (logInfo);
        }
    }
    
    /**
     * 记录info级别的日志
     * 
     * @param logInfo 日志信息
     * @param t Throwable
     */
    public void infoLog (String logInfo, Throwable t)
    {
        if (logger.isInfoEnabled ())
        {
            logger.info (logInfo, t);
        }
    }
}
