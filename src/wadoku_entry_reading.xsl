<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:wd="http://www.wadoku.de/xml/entry"
                version="1.0">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:strip-space elements="*"/>
    

<xsl:template match="wd:entry">
            <xsl:apply-templates/>
</xsl:template>

    <xsl:template match="wd:pron">
        <xsl:choose>
            <xsl:when test="@type='hatsuon'"/>
            <xsl:when test="@type='romaji'"/>
            <xsl:otherwise>
                <xsl:value-of select="./wd:text" />
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    
    <xsl:template match="wd:orth"/>
    <xsl:template match="wd:expl"/>
    <xsl:template match="wd:def"/>
    <xsl:template match="wd:pos"/>
    <xsl:template match="wd:tr"/>
    
<xsl:template match="wd:sense"/>
<xsl:template match="wd:link"/> 

<xsl:template match="wd:trans"/>
<xsl:template match="wd:usg"/>
<xsl:template match="wd:ref"/>  

    
</xsl:stylesheet>
