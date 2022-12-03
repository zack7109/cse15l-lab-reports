```Task: Changing the name of the start parameter and its uses to base```

***Shortest Sequence*** ``:13,23s/start/base<enter>:wq<enter>``

First, we have to open the file in vim <br>
<img width="321" alt="image" src="https://user-images.githubusercontent.com/114643274/205428475-ed1592b9-84de-41b1-bca4-ecba127a7f84.png">


Then we type the command: ``:13,23s/start/base``<br>
<img width="97" alt="image" src="https://user-images.githubusercontent.com/114643274/205428418-eeac0dc8-6397-4771-8292-add13c8d802d.png">

What this command does is from lines 13-23, replace "start" with "base"<br>
We can see this change happen after hitting enter<br>
<img width="491" alt="image" src="https://user-images.githubusercontent.com/114643274/205428550-ab1aa100-ba67-4689-9cab-1530b8779fbc.png">

From there, we can save and quit out with ``:wq`` and pressing ``enter`` <br>
<img width="48" alt="image" src="https://user-images.githubusercontent.com/114643274/205428580-dad2a615-1d4b-4bb1-8483-a321a798881f.png">


**PART 2**
First Way: Editing the file in VSC, scp'ing it to the remote, and running bash
Time: 20.31 seconds

Second Way: Opening the file in VIM on the remote, editing and saving the file, then running bash
Time: 9.32 seconds


While the second way (VIM) was definitely faster, I feel like there is a high chance of me making an error if I don't have the command ready in my copy and paste and immediately know what I'm doing. VSC would highlight my errors and in general is way easier to navigate as well. If I had to only make a single line change and knew where it was and exactly what I had to do, I would probably use VIM, but if I had to make sure that my code worked or had to write an entire file there's little chance that you would be able to even pay me to write it in VIM.
<br><br><br><br><br>
*\*NOTE: I'M SORRY FOR TURNING THIS IN LATE I HAD A POST IT WITH THE SHORTEST SEQUENCE ON IT JUST SITTING ON MY DESK AND JUST NEVER MADE THE WRITE UP FOR IT*
