***Lab Report 3***

I decided to go with using the "find" command. The three augmentations I found were ``-type``, ``-size``, and ``-atime``, all of which serve useful purposes in augmenting what files are returned.
<br />
<br />
**``-type``** - this command filters all the items returned for a specific item type, whether that be for directories or files. This is useful because it can help separate the two, allowing you to modify all the files within a folder without attempting to modify the directories.
<br />
**EXAMPLE 1:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036635254930284574/unknown.png)
<br />
This example says to find all the items within the ``/government`` folder that match type d (which means a directory). It in turn returns all the directories in ``/government`` (along with ``/government`` itself).

**EXAMPLE 2:**
![Image](https://cdn.discordapp.com/attachments/481212732562079756/1036636097310109696/unknown.png)
<br/>
This example says to find all the items within ``/biomed`` that match type f (which means a file). It returns all the files within ``/biomed`` (not all of them shown).

**EXAMPLE 3:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036636759477473340/unknown.png)
<br/>
I then ran the same command on ``/911report``, which returned all the files within ``/911report`` (which actually do fit on a page).


**``-size``** - this command filters all the items returned for a specific file size, which can be modified to incorporate files above, below, or at a certain file size
<br/>
**EXAMPLE 1:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036634804147462184/unknown.png)
<br/>
This example returns all the items in ``/biomed`` for files larger than 75 kilobytes.

**EXAMPLE 2:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036638464256520223/unknown.png)
<br/>
This example returns all the items in ``/biomed`` for files smaller than 10KB.

**EXAMPLE 3:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036634948045643937/unknown.png)
<br/>
This example attempts to return all the files in ``/plos`` that are larger than 75KB, but finds nothing.


**``-atime``** - this command filters all the items returned for items accessed before a certain amount of time (in days)
<br/>
**EXAMPLE 1:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036632690977415258/unknown.png)
<br/>
This example shows the files in ``/government`` that have been accessed at least 8 days ago (``-atime`` by default checks for a day, so +7 would be 8 within days).

**EXAMPLE 2:**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036632915251056650/unknown.png)
<br/>
This example tries to find files in ``/government`` that have been accessed at least 21 days ago, but cannot find anything (since the folder was downloaded/created within that time).

**EXAMPLE 3**
![Image](https://media.discordapp.net/attachments/481212732562079756/1036633081970446417/unknown.png)
I ran the same test as example 1 in the ``/biomed`` folder.
