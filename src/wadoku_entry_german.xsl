<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:wd="http://www.wadoku.de/xml/entry"
                version="1.0">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:strip-space elements="*"/>
    

<xsl:template match="wd:entry">
            <xsl:apply-templates/>
</xsl:template>
    
    
    <xsl:template match="wd:text">
        <xsl:if test="@hasPrecedingSpace='true'">
            <xsl:text> </xsl:text>
        </xsl:if>
        <xsl:value-of select="text()"/>
        <xsl:if test="@hasFollowingSpace='true'">
            <xsl:text> </xsl:text>
        </xsl:if>
    </xsl:template>
    
    
    <xsl:template match="wd:expl">

            <xsl:if test="count(preceding-sibling::*)&gt;0">
                <xsl:text>; </xsl:text>
            </xsl:if>
            <xsl:apply-templates/>

    </xsl:template>
    

    <xsl:template match="wd:orth"/>

    <xsl:template match="wd:pron"/>

    <xsl:template match="wd:pos"/>
    

    <xsl:template match="wd:tr">
        <xsl:text> </xsl:text>
        <xsl:apply-templates/>
    </xsl:template>
    
<xsl:template match="wd:sense">  
        <xsl:if test="count(../wd:sense)>1">  
        <xsl:text>[</xsl:text>  
        <xsl:value-of select="position()-2"/>  
        <xsl:text>]</xsl:text>  
        </xsl:if>  
        <xsl:apply-templates/>  
        <xsl:text>.</xsl:text>
</xsl:template> 


<xsl:template match="wd:token">
        <xsl:if test="preceding-sibling::*[1][self::wd:bracket]">
            <xsl:text> </xsl:text>
        </xsl:if>
        <xsl:apply-templates/> 
    </xsl:template>
    

<xsl:template match="wd:bracket[@meta]"/>

    <xsl:template match="wd:bracket">
        <xsl:if test="preceding-sibling::*[1]
        [self::wd:token or
         self::wd:def or
         self::wd:famn]">
            <xsl:text> </xsl:text>
        </xsl:if>
        <xsl:if test="preceding-sibling::*[1][self::wd:text[not(@hasFollowingSpace)]]">
            <xsl:text> </xsl:text>
        </xsl:if>
        <xsl:text>(</xsl:text>
        <xsl:apply-templates/>
        <xsl:text>)</xsl:text>
    </xsl:template>



<xsl:template match="wd:link"/> 
<xsl:template match="wd:ref"/>  

 <xsl:template match="wd:trans">
        <xsl:value-of select="text()"/>
        <xsl:apply-templates/>
        <xsl:if test="not(position()=last())">
        <xsl:text>; </xsl:text>
        </xsl:if>
    </xsl:template>
    
    <xsl:template match="wd:etym">
        <xsl:text>(</xsl:text>
        <xsl:apply-templates/>
        <xsl:text>)</xsl:text>
    </xsl:template>


    <xsl:template match="wd:trans[@langdesc='scientific']">
        <xsl:text>(wiss. N.:</xsl:text>
        <xsl:value-of select="text()"/>
        <xsl:apply-templates/>
        <xsl:text>)</xsl:text>
    </xsl:template>
    
    <xsl:template match="wd:usg[@reg='lit']">
            <xsl:text> </xsl:text>
            <xsl:text>(schriftspr.)</xsl:text> 
    </xsl:template>
    
<xsl:template match="wd:usg[@type]">  
        <xsl:choose>  
            <xsl:when test="@type='time'">  
                <xsl:text> </xsl:text>  
                <xsl:text>(</xsl:text>  
                <xsl:value-of select="text()"/>  
                <xsl:text>)</xsl:text>  
            </xsl:when>  
            <xsl:otherwise>  
                <xsl:text> </xsl:text>  
                <xsl:text>{</xsl:text>  
                <xsl:value-of select="text()"/>  
                <xsl:text>}</xsl:text>  
            </xsl:otherwise>  
        </xsl:choose>  
</xsl:template>  

    
</xsl:stylesheet>
