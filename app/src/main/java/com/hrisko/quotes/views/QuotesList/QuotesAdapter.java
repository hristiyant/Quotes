package com.hrisko.quotes.views.QuotesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder> {

    private List<Quote> mQuotes;
    private OnQuoteClickListener mOnQuoteClickListener;

    @Inject
    public QuotesAdapter() {
        mQuotes = new ArrayList<>();
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_item, parent, false);
        int height = parent.getMeasuredHeight() / 3;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.setOnClickListener(mOnQuoteClickListener);
        holder.bind(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

    public Quote getItem(int position) {
       return mQuotes.get(position);
    }

    public void clear() {
        mQuotes.clear();
    }

    public void addAll(List<Quote> quotes) {
        mQuotes.addAll(quotes);
    }

    public void setOnQuoteClickListener(OnQuoteClickListener onQuoteClickListener) {
        this.mOnQuoteClickListener = onQuoteClickListener;
    }

    public static class QuoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_author_name)
        TextView mAuthorNameTextView;

        @BindView(R.id.tv_topic)
        TextView mTopicTextView;

//        @BindView(R.id.tv_content)
//        TextView mContentTextView;

        @BindView(R.id.iv_author_image)
        ImageView mAuthorImageImageView;


        private OnQuoteClickListener mOnQuoteClickListener;
        private Quote mQuote;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Quote quote) {
            mAuthorNameTextView.setText(quote.getAuthorName());
            mTopicTextView.setText(quote.getTopic());
//            mContentTextView.setText(quote.getQuote());
            Picasso.get().load(quote.getImageUrl()).into(mAuthorImageImageView);
            mQuote = quote;
        }

        @OnClick
        public void onClick() {
            mOnQuoteClickListener.onClick(mQuote);
        }

        public void setOnClickListener(OnQuoteClickListener onQuoteClickListener) {
            mOnQuoteClickListener = onQuoteClickListener;
        }
    }

    interface OnQuoteClickListener {
        void onClick(Quote quote);
    }

}
