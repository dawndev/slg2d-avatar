### …or create a new repository on the command line
```bash
echo "# slg2d-avatar" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M master
git remote add origin git@github.com:tagwan/slg2d-avatar.git
git push -u origin master
```

### …or push an existing repository from the command line
```bash
git remote add origin git@github.com:tagwan/slg2d-avatar.git
git branch -M master
git push -u origin master
```

### …or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.