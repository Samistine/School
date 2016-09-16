<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Dog Breeds</h2>
                <table border="1" style="background-color: lightgrey; border: 5px solid red;">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:center; width:10%">Name</th>
                        <th style="text-align:left;   width:70%">Description</th>
                        <th style="text-align:center;  width:5%">Ranking</th>
                        <th style="text-align:left;   width:15%">Personality</th>
                    </tr>
                    <xsl:for-each select="breeds/breed">
                        <tr>
                            <td style="text-align:center;">
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="description"/>
                            </td>
                            <td style="text-align:center">
                                <xsl:value-of select="ranking"/>
                            </td>
                            <td>
                                <xsl:value-of select="personality"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>