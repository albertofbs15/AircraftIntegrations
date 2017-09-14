<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:tns="http://aerolineas-latinoamericanas/contract/messages"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes="#default tns">
	
	<xsl:template match="/">

		<security-incident>
			<level>
				<xsl:value-of select="/tns:aircratline-message/tns:flight-leg/tns:domain-events-info/tns:alert-on-air/tns:alert-type"/>
			</level>
			<description>
                <xsl:value-of select="/tns:aircratline-message/tns:flight-leg/tns:domain-events-info/tns:alert-on-air/tns:description"/>
			</description>
			<flight-external-key>
                <xsl:value-of select="/tns:aircratline-message/tns:flight-leg/@external-key"/>
			</flight-external-key>
			<aircraft-tail-number>
                <xsl:value-of select="/tns:aircratline-message/tns:tail-number"/>
			</aircraft-tail-number>
            <incident-date>
                <xsl:value-of select="substring(/tns:aircratline-message/tns:flight-leg/@external-key,9,8)"/>
            </incident-date>
		</security-incident>

	</xsl:template>
</xsl:stylesheet>