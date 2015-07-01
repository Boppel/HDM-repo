<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
    xmlns="http://www.w3.org/1999/xhtml">

    <xsl:output indent="yes" method="xml" />

    <xsl:template match="/html">
        <html >
            <head>
                <style> <!-- a courtesy to all non-CSS geeks on this planet -->                    
         table, th, td {
           border:1px solid black;
           border-collapse: collapse;
         }
       </style>
                <title>List of images</title>
            </head>
            <body>
               
                <xsl:choose>
                    <!-- wenn img elemente da sind, mach das -->
                    <xsl:when test="//img">
                        <h2>List of images:</h2>
                        <table>
                            <tr>
                                <th>No.</th> <th>URL</th> <th>alt description</th>
                            </tr>
                            <xsl:apply-templates select="//img"/>
                        </table>
                    </xsl:when>
                    <xsl:otherwise>
                       <h2>Input document does not contain any images.</h2>
                    </xsl:otherwise>
                </xsl:choose>
                
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="img">
        <tr>
            <td>
                <xsl:value-of select="position()"/>
            </td>
            <td>
                <xsl:value-of select="@src"/>
            </td>
            <td>
                <xsl:choose>
                    <xsl:when test="@alt">
                        <xsl:value-of select="@alt"/>
                    </xsl:when>
                    <xsl:otherwise>
                        -
                    </xsl:otherwise>
                </xsl:choose>
                
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>