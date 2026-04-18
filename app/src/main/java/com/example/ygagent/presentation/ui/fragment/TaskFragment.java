package com.example.ygagent.presentation.ui.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ygagent.common.utils.YGToast;
import com.example.ygagent.databinding.FragmentTaskBinding;
import com.example.ygagent.domain.entity.Task;
import com.example.ygagent.presentation.ui.adapter.TaskAdapter;
import com.example.ygagent.presentation.ui.adapter.listener.OnTaskAcceptListener;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends BaseFragment<FragmentTaskBinding> {

    public static final String TAG = "YG_TaskFragment";
    private TaskAdapter mAdapter;
    private final OnTaskAcceptListener mAcceptListener = new OnTaskAcceptListenerImpl();

    @Override
    protected FragmentTaskBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentTaskBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        initRecyclerView();
        initSwipeRefresh();
    }

    private void initSwipeRefresh() {
        mBinding.srlRefresh.setOnRefreshListener(this::loadTasks);
        mBinding.srlRefresh.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
    }

    private void initRecyclerView() {
        mAdapter = new TaskAdapter(mAcceptListener);
        mBinding.rvTask.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvTask.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        loadTasks();
    }

    private void loadTasks() {
        List<Task> taskList = getMockTasks();
        mAdapter.submitList(taskList);

        if (mBinding.srlRefresh.isRefreshing()) {
            mBinding.srlRefresh.setRefreshing(false);
        }

        YGToast.Show(getContext(), "已加载 " + taskList.size() + " 个任务");

    }

    private List<Task> getMockTasks() {
        List<Task> tasks = new ArrayList<>();
        long now = System.currentTimeMillis();

        tasks.add(new Task(1, "帮我取快递", "从菜鸟驿站取快递到宿舍3号楼，取件码1234",
                "菜鸟驿站 → 宿舍3号楼", 5.0, "不限性别", "张三", now - 600000, 0));

        tasks.add(new Task(2, "代买午餐", "帮忙去食堂买份午餐，一荤两素",
                "食堂 → 教学楼A座", 8.0, "不限性别", "李四", now - 1800000, 0));

        tasks.add(new Task(3, "送文件到办公室", "将打印好的文件送到行政楼302办公室",
                "打印店 → 行政楼302", 6.0, "男", "王五", now - 3600000, 0));

        tasks.add(new Task(4, "帮忙搬行李", "从宿舍搬到校门口，有电梯",
                "宿舍5号楼 → 校门口", 15.0, "男", "赵六", now - 7200000, 0));

        tasks.add(new Task(5, "代取外卖", "美团外卖送到宿舍楼下",
                "宿舍楼下 → 宿舍7号楼", 3.0, "不限性别", "孙七", now - 1800000, 0));

        return tasks;
    }

    private class OnTaskAcceptListenerImpl implements OnTaskAcceptListener {

        @Override
        public void onAccept(Task task) {
            YGToast.Show(getContext(), "准备接受任务：" + task.getTitle());
        }
    }
}