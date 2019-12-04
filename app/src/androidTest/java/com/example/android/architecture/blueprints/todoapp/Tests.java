package com.example.android.architecture.blueprints.todoapp;

import android.util.Log;
import androidx.test.core.app.ActivityScenario;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.file.Files;

import static com.example.android.architecture.blueprints.todoapp.StepWrapper.stepWrapper;

public class Tests {




    @BeforeEach
    public void launchActivity() {
        ActivityScenario.launch(TasksActivity.class);
    }

    /*@BeforeEach
    public void clearOldAllureResults() {
        File folder = new File ("C:\\Users\\a.sandler\\AppData\\Local\\Android\\Sdk\\platform-tools\\allure-results");
        File[] contents = folder.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (!Files.isSymbolicLink(f.toPath())) {
                    f.delete();
                }
            }
            Log.d("Setup", "Allure reports have been cleared");
        }
    }*/

    @Test
    public void addNewTaskTest() throws InterruptedException {
        Thread.sleep(1000);
        stepWrapper("clickButton", "clickButtonAdd", R.id.add_task_fab);
        stepWrapper("addNewTask", "addNewTaskName", R.id.add_task_title_edit_text, "Go to the shopping");
        stepWrapper("addNewTask", "addNewTaskDescription", R.id.add_task_description_edit_text, "Go to the shopping with my friend");
        stepWrapper("clickButton", "clickButtonSave", R.id.save_task_fab);
        stepWrapper("CheckTest", "check", R.id.toolbar);
    }

    @Test
    public void DeleteTest() throws InterruptedException {
        Thread.sleep(5000);
        stepWrapper("clickButton", "clickButtonTasksList", R.id.tasks_list);
        stepWrapper("clickButton", "clickButtonDelete", R.id.menu_delete);
        stepWrapper("CheckTest", "check", R.id.toolbar);

        stepWrapper("clickButton", "clickButtonTasksList", R.id.tasks_list);
        stepWrapper("clickButton", "clickButtonDelete", R.id.menu_delete);
        stepWrapper("CheckTest", "check", R.id.toolbar);

        stepWrapper("CompleteTest", "check", "You have no tasks!");
    }

}
