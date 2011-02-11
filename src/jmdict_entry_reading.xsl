<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:strip-space elements="*"/>
    
    


<xsl:template match="entry">
            <xsl:apply-templates/>
</xsl:template>
    
    <xsl:template match="reb">
        <xsl:value-of select="text()"/> 
    </xsl:template>
    
    <xsl:template match="r_ele">
        <xsl:apply-templates/>
        <xsl:text> </xsl:text>
    </xsl:template>
    
<xsl:template match="n"/>
<xsl:template match="re_inf"/>
<xsl:template match="ke_inf"/>
<xsl:template match="pos"/>
<xsl:template match="info"/>
<xsl:template match="s_inf"/>
<xsl:template match="ke_pri"/>
<xsl:template match="re_pri"/>
<xsl:template match="k_ele" />
<xsl:template match="ent_seq"/>
<xsl:template match="gloss"/>     
<xsl:template match="xref"/>
<xsl:template match="sense"/>

    
</xsl:stylesheet>
