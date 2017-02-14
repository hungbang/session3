<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" />
	<xsl:template match="/">

		<html>
			<head>
				<title>XML Data</title>
			</head>
			<body>
				Print something
				<xsl:for-each select="Employees/Employee">
					First Name:
					<xsl:value-of select="FirstName" />
					Last Name:
					<xsl:value-of select="LastName" />
					Location:
					<xsl:value-of select="Location" />
				</xsl:for-each>

			</body>

		</html>
	</xsl:template>

</xsl:stylesheet>