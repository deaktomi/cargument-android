package cargument.dantomdev.com.cargument.ui.main;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.ui.conversation.ConversationActivity;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessageActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    Button btnNewConversation;
    ListView lvConversations;

    @Override
    protected void onNewIntent (Intent intent) {
        setIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargumentApplication.injector.inject(this);

        btnNewConversation = (Button)findViewById(R.id.btnNewConversation);
        lvConversations = (ListView) findViewById(R.id.lvConversations);

        btnNewConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMessage();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        String userId;
        //userId = getIntent().getStringExtra("userId");
        userId = "1";
        mainPresenter.getConversations(userId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessages(List<Conversation> conversations) {
        lvConversations.setAdapter(new ConversationAdapter(conversations));
    }

    @Override
    public void openMessage(int id) {
        Intent intent = new Intent(this, ConversationActivity.class);
        intent.putExtra("conversationId", id);
        startActivity(intent);
    }

    @Override
    public void newMessage() {
        Intent intent = new Intent(this, NewMessageActivity.class);
        startActivity(intent);
    }

    private class ConversationAdapter extends BaseAdapter {

        private List<Conversation> conversations;

        public ConversationAdapter(List<Conversation> conversations){
            this.conversations = conversations;
        }

        @Override
        public int getCount() {
            return conversations.size();
        }

        @Override
        public Conversation getItem(int position) {
            return conversations.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.conversation_listitem, null);
            }
            final Conversation c = getItem(position);
            TextView tvConversationPartner = (TextView) convertView.findViewById(R.id.tvConversationPartner);
            Button btnDetails = (Button) convertView.findViewById(R.id.btnDetails);
            tvConversationPartner.setText(c.getUser2().getName() + " - " + c.getUser2().getRegNumber());


            btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMessage(c.getConversationId());
                }
            });

            return convertView;
        }
    }

}
