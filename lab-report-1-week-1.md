Hello! Welcome to CSE15L!

There are many things we will be doing in this class, and many of them will require you to remotely sign into a virtual computer hosted by UCSD.

1. First, use the [account lookup tool](https://sdacs.ucsd.edu/~icc/index.php) and find your username, and change the password to your account. These will be used to access resources for the class, and connect remotely to your computer.
2. Next, download [Visual Studio Code](https://code.visualstudio.com/) onto your device. Make sure you download the correct version for your operating system (chromebook and tablet are not supported). Follow the instructions from the setup wizard to install.
3. WINDOWS USERS ONLY: If you have a windows operating system, you will need to download and install [OpenSSH](https://learn.microsoft.com/en-us/windows-server/administration/openssh/openssh_install_firstuse?tabs=gui). The requirements and instructions to install will be shown in the link provided.
4. Open Visual Studio Code. The program should look like this:
![Image](https://cdn.discordapp.com/attachments/481212732562079756/1025574512282046494/unknown.png)
5. Create a new text file and save it as a .java file (name the file and put “.java” at the end of it). Open up the terminal using the “terminal” tab at the top of the screen (shown below).

![Image](https://cdn.discordapp.com/attachments/481212732562079756/1025574908010450954/unknown.png)

6. Next, we will be remotely connecting to your account. Type in the terminal the following command: ```ssh [your account name]@ieng6.ucsd.edu```
and prompted to enter your password. Be careful when doing this, as no feedback will be given by the computer (it will not show what you are typing). Press enter when you are done.
    If you typed in your password correctly, you should see a handful of information about your connection pop up in the terminal (see below)
    If you did not type your password correctly, it will re-prompt you for your password
    If you continue having problems logging into your account, you can either type the command “```exit```” into the terminal, or press **control + c** to stop the terminal from running.
![Image](https://cdn.discordapp.com/attachments/481212732562079756/1025575051061362738/unknown.png)
7. After you have successfully logged into your account, try testing out commands such as the following:
```
pwd
ls
cd
mkdir
```

* You may stop your connection by either typing the command ```exit``` into the terminal, or pressing ```control + d```

8. Next, we will try moving over files using the command ```scp```. Log out of your account. Create a new file in Visual Studio Code, and save it as “WhereAmI.java” (make sure you are on your own machine at home). Paste the following contents into the document and save it.
```
class WhereAmI {
  		public static void main(String[] args) {
    			System.out.println(System.getProperty("os.name"));
    			System.out.println(System.getProperty("user.name"));
    			System.out.println(System.getProperty("user.home"));
    			System.out.println(System.getProperty("user.dir"));
  }
}
```
9. Compile the file using the command ```javac WhereAmI.java```, then run the code using the command ```java WhereAmI```. Assuming the code works, continue to the next step. If not, make sure you set up the code and ran the commands correctly
10. Move back to your terminal and paste the following command:
```scp WhereAmI.java [your username]@ieng6.ucsd.edu:~/ ```
  It will ask for your password again. This will copy over the file to your virtual machine. It will show some information about the status of the file transfer.
![Image](https://cdn.discordapp.com/attachments/481212732562079756/1025575051061362738/unknown.png)
11. After copying over the file, try compiling and running the code on your virtual machine. It should show different information than it did the first time.
12. Now, we will try to make the logging in process less painful and complicated by setting up SSH keys. Log back out of your account, then run the ```command ssh-keygen```. It will prompt you to pick a folder to save a file into, which you should leave empty (to save it to your current, root directory). Then, it will prompt you for a password. You may leave this empty. It will then ask you to confirm that password (if you left it empty, leave it empty again). After that, the file should be created and you will receive a key fingerprint and randomart image (which you don’t have to worry about).
![Image](https://media.discordapp.net/attachments/481212732562079756/1025575303545888778/unknown.png)
13. Now, sign back into your account and run the command ```mkdir .ssh```. Use ls to make sure the file is there. Then, you can log back out.
14. Finally, run the command
```scp /Users/joe/.ssh/id_rsa.pub [your username]@ieng6.ucsd.edu:~/.ssh/authorized_keys```
and enter in your password one final time. This will make your virtual machine recognize that the person signing in is you, and will allow you to either sign in with no password (if you entered nothing), or a new password you have chosen. This will make it substantially easier to deal with logging in and out of your account.
![Image](https://media.discordapp.net/attachments/481212732562079756/1025575442524143627/unknown.png)
(Notice how it did not prompt this user for their password and directly logged in)
15. Furthermore, you can now run commands on your virtual machine from your home machine. Try the command ```ssh cs15lfa22@ieng6.ucsd.edu "ls"```. It should have the same result as logging into your machine and running the command ```ls```. You can also run multiple commands using semicolons between the commands. 
![Image](https://media.discordapp.net/attachments/481212732562079756/1025575729544564836/unknown.png)
*TIP: you can use the up arrow to access commands previously typed into the terminal. Try running commands with as minimal keystrokes (presses of keys or the mouse buttons) as possible. See how you can optimize how little keystrokes you need to run commands, and try getting comfortable with running commands as efficiently as possible



*Note: certain images were obtained from the group report with permission from the members providing the images. This was solely due to the fact that my account was not working at the time the lab was going on, so I was given a TA account and was not able to run certain commands (and just had to follow along with other people). The issue should be fixed now, and future lab reports should contain images solely taken by me.
