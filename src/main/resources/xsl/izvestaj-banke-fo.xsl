<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/izvestajBanke">
        <fo:root font-family="Helvetica" margin-right="60pt" margin-left="60pt">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izvestaj-klijenta-page" margin-bottom="80pt" margin-top="80pt">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izvestaj-klijenta-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-size="20pt" font-weight="bold">
                        Izvestaj Banke
                    </fo:block>




                   <xsl:apply-templates></xsl:apply-templates>


                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>


    <xsl:template match="naziv">
        <fo:block margin-top="10pt">
            <fo:inline> Naziv banke : <xsl:value-of select="text()"/>
               </fo:inline>
        </fo:block>
    </xsl:template>



    <xsl:template match="pib">
        <fo:block margin-top="30pt">
            <fo:inline> PIB : <xsl:value-of select="text()"/>
            </fo:inline>
        </fo:block>


    </xsl:template>

    <xsl:template match="datum">
        <fo:block margin-top="10pt">
            <fo:inline> Datum : <xsl:value-of select="text()"/>
            </fo:inline>
        </fo:block>

        <fo:block margin-top="30pt" font-weight="bold" font-size="13pt">
            <fo:inline padding-right="20pt">
                Broj racuna
            </fo:inline >
            <fo:inline padding-right="20pt"> ID Klijenta
            </fo:inline>
            <fo:inline padding-right="20pt"> Datum Otvaranja
            </fo:inline>
            <fo:inline padding-right="40pt"> Valuta
            </fo:inline>
            <fo:inline> Stanje
            </fo:inline>
        </fo:block>
    </xsl:template>

    <xsl:template match="stavka">
		 <fo:block margin-top="20pt">
		     <fo:inline padding-right="100pt"> <xsl:value-of select="racun"/></fo:inline>
		     <fo:inline padding-right="60pt"> <xsl:value-of select="klijentId"/></fo:inline>
		     <fo:inline padding-right="30pt"> <xsl:value-of select="datumOtvaranja"/></fo:inline>
		     <fo:inline padding-right="30pt"> <xsl:value-of select="valuta"/></fo:inline>
		     <fo:inline> <xsl:value-of select="stanje"/></fo:inline>
           </fo:block>
    </xsl:template>




</xsl:stylesheet>
