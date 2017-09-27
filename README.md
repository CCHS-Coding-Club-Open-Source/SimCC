# SimCC
A simulation of CCHS.
[ ![Codeship Status for CCHS-Coding-Club-Open-Source/SimCC](https://app.codeship.com/projects/bd5ec920-85ce-0135-6f9a-3680cfc00fed/status?branch=master)](https://app.codeship.com/projects/248009)


# Setup for editing
PART 1: Downloading the repository.

  For newbies:
  
    1. Download/Install/Setup GitHub Desktop. https://desktop.github.com/
    2. Clone the Repository.
      (File -> Clone Repository... -> CCHS-Coding-Club-Open-Source/SimCC -> Choose the Local Path -> Clone)

  
  For git pros:
    
    Clone, Fetch, Pull, etc. Pretty much same as usual. If you're a git pro, you probably know the drill better than me as I typically use the Desktop Client anyways.

PART 2: Setting up Eclipse
  1. Download/Install (from https://www.eclipse.org/). If given multiple choices, pick the Java option.
  2. Open Eclipse and select a workspace -- this is where eclipse will store the information about your projects. You can use one location for everything, or select a different workspace for each project (letting you more quickly reset a specific project). If you aren't prompted at startup, you can select a workspace from "File -> Switch Workspace"
  3. Click "Workbench" near the top right.
  4. Import the SimCC project
    
    a. File -> Import... -> General -> Projects from Folder or Archive -> Next -> Directory...
    b. Select the SimCC Project folder -- Not the whole Repository folder
      For example: If I cloned the repository to ~/Documents/GitHub/SimCC, I would select ~/Documents/GitHub/SimCC/SimCC in Eclipse. The folder should be the one with "src" in it.
  5. Finish
  
  If successful, you should have the project's packages on the left.


# Pushing/Pulling/Syncing/Fetching Changes from/to the repository using GitHub Desktop
To 'upload/download' changes, click the "fetch" button if availible (it may've done it automatically), then click the "pull" or "push" button.

Fetch checks for changes, Pull downloads new changes from GitHub, and Push uploads new changes from your computer.


# Please note
We are mostly pulling/pushing to the master branch of the main repository at the moment. Avoid pull requests, forks, and branches unless you know what you're doing, as it's difficult to collaborate when we don't realize you are working seperately.
