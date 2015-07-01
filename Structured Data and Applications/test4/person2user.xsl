<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="2.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/persons">
        <users>
            <xsl:apply-templates select="person[@id]"/>
        </users>
    </xsl:template>
    
    <xsl:template match="person">
        <user index="{position()}" uid="user_{@id}">
            <uid><xsl:value-of select="lastName"/></uid>
            <fullName>
                <xsl:value-of select="firstName"/>
                <xsl:text> </xsl:text>
                <xsl:value-of select="lastName"/>
             </fullName>
            <xsl:choose>
                <xsl:when test="email">
                    <contact type="email"><xsl:value-of select="email"/></contact>
                </xsl:when>
                <xsl:when test="phone">
                    <contact type="phone"><xsl:value-of select="phone"/></contact>
                </xsl:when>
                <xsl:otherwise>
                    <contact type="none"></contact>
                </xsl:otherwise>
            </xsl:choose>
             
        </user>
    </xsl:template>
    
    
    <xsl:template match="contact">
        
    </xsl:template>
    
    
    
    <!-- Just in case of forgotten rules. -->
    <xsl:template match="*">
        <xsl:message>
            <xsl:text>Error: No template matching element '</xsl:text>
            <xsl:value-of select="name(.)"/>
            <xsl:text>'</xsl:text>
        </xsl:message>
    </xsl:template>
    
</xsl:stylesheet>