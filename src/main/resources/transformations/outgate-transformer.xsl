<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:p="http://xml.mxi.com/xsd/csi/swa/flight/flight-leg-response/1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes="#default p">
	
	<xsl:template match="/">

		<OUTGATE-FLIGHTS>
			<EXTERNAL-KEY>
				<xsl:value-of select="/p:flight-leg-message/p:flight-leg/p:flight-attributes/p:external-key"/>
			</EXTERNAL-KEY>
			<NAME>
				<xsl:value-of select="/p:flight-leg-message/p:flight-leg/p:flight-attributes/p:flight-name"/>
			</NAME>
			<BARCODE>
				<xsl:value-of select="/p:flight-leg-message/p:flight-leg/p:aircraft/p:barcode"/>
			</BARCODE>
		</OUTGATE-FLIGHTS>

	</xsl:template>
</xsl:stylesheet>