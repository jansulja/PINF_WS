<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/izvestajKlijenta">
        <fo:root font-family="Helvetica" margin-right="80pt" margin-left="80pt">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izvestaj-klijenta-page" margin-bottom="80pt" margin-top="80pt">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izvestaj-klijenta-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-size="16pt" font-weight="bold">
                        Izvestaj klijenta
                    </fo:block>

                   


                   <xsl:apply-templates></xsl:apply-templates>


                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>


    <xsl:template match="naziv">
        <fo:block margin-top="10pt">
            <fo:inline> Klijent : <xsl:value-of select="text()"/>
               </fo:inline>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="datum">
        <fo:block margin-top="10pt">
            <fo:inline> Datum : <xsl:value-of select="text()"/>
            </fo:inline>
        </fo:block>
    </xsl:template>
    
    <xsl:template match="brojRacuna">
        <fo:block margin-top="10pt">
            <fo:inline> Racun : <xsl:value-of select="text()"/>
            </fo:inline>
        </fo:block>
        
        <fo:block margin-top="30pt" font-weight="bold" font-size="13pt">
            <fo:inline padding-right="100pt">
                Datum prometa
            </fo:inline>
            <fo:inline> Promet
            </fo:inline>
        </fo:block>
        
    </xsl:template>

    <xsl:template match="stavkaIzvestaja">
		 <fo:block margin-top="20pt">
		     <fo:inline padding-right="100pt"> <xsl:value-of select="datumPrometa"/></fo:inline>
		     <fo:inline>      <xsl:value-of select="promet"/></fo:inline>
           </fo:block>
    </xsl:template>




</xsl:stylesheet>
