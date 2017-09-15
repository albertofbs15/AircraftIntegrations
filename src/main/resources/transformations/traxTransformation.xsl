<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:tns="http://aerolineas-latinoamericanas/contract/messages"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes="#default tns">

	<xsl:template match="/">
		<cancelRequestt>
			<aircraftIdentifier>
				<xsl:value-of select="substring(/tns:aircratline-message/tns:tail-number,3)"/>
			</aircraftIdentifier>
			<externalKey>
				<xsl:value-of select="/tns:aircratline-message/tns:flight-leg/@external-key"/>
			</externalKey>
			<description>
				<xsl:value-of select="/tns:aircratline-message/tns:flight-leg/tns:domain-events-info/tns:cancel-flight/tns:description"/>
			</description>
            <date>
                <xsl:value-of select="/tns:aircratline-message/@process-date"/>
            </date>
		</cancelRequestt>

	</xsl:template>
</xsl:stylesheet>