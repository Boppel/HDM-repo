<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="xml" indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="/book">
        
        <html>
            <head>
                <title>
                    <xsl:value-of select="title"/>
                </title>
            </head>
            <xsl:choose>
                <xsl:when test="@id">
                    <body id="{@id}">
                        <xsl:apply-templates select="title"/>
                        <xsl:apply-templates select="chapter"/>
                    </body>
                </xsl:when>
                <xsl:otherwise>
                    <body>
                        <xsl:apply-templates select="title"/>
                        <xsl:apply-templates select="chapter"/>
                    </body>
                </xsl:otherwise>
            </xsl:choose>
            
            
        </html>
    </xsl:template>
    
    <xsl:template match="book/title">
        <h1>
            <xsl:value-of select="."/>
        </h1>
    </xsl:template>
    
    <xsl:template match="chapter">
        
        <xsl:apply-templates select="title"/>
        <xsl:apply-templates select="para"/>
    </xsl:template>
    
    <xsl:template match="para">
        <xsl:choose>
            <xsl:when test="@id">
                <p id="{@id}">
                    <xsl:apply-templates select="text()|link|emphasis"/>
                </p>
            </xsl:when>
            <xsl:otherwise>
                <p>
                    <xsl:apply-templates select="text()|link|emphasis"/>
                </p>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <xsl:template match="link">
        <a href="#{@linkend}">
            <xsl:value-of select="."/>
        </a>
    </xsl:template>
    
    <xsl:template match="emphasis">
        <em>
            <xsl:value-of select="."/>
        </em>
    </xsl:template>
    
    <xsl:template match="chapter/title">
        <xsl:choose>
            <xsl:when test="../@id">
                <h2 id="{../@id}">
                    <xsl:value-of select="."/>
                </h2>
            </xsl:when>
            <xsl:otherwise>
                <h2>
                    <xsl:value-of select="."/>
                </h2>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>



    <!-- Handling missing templates -->
    <xsl:template match="*">
        <p>
            <xsl:text>No template defined for element '</xsl:text>
            <xsl:value-of select="name(.)"/>
            <xsl:text>'</xsl:text>
        </p>
    </xsl:template>
    
</xsl:stylesheet>